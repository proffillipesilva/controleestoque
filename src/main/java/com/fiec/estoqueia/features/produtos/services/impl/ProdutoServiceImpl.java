package com.fiec.estoqueia.features.produtos.services.impl;

import com.fiec.estoqueia.features.produtos.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.features.produtos.business.entities.Produtos;
import com.fiec.estoqueia.features.produtos.business.repositories.ProdutoRepository;
import com.fiec.estoqueia.features.produtos.services.ProdutoService;
import jakarta.annotation.PostConstruct;
import net.coobird.thumbnailator.Thumbnails;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produtos criaProduto(CreateProdutoDto createProdutoDto) {
        Produtos produto = new Produtos();
        produto.setAtributos(createProdutoDto.getAtributos());
        produto.setDescricao(createProdutoDto.getDescricao());
        produto.setCodigoBarra(createProdutoDto.getCodigoBarra());
        produto.setNome(createProdutoDto.getNome());
        produto.setPrecoCusto(createProdutoDto.getPrecoCusto());
        produto.setPrecoVenda(createProdutoDto.getPrecoVenda());
        produto.setUnidadeMedida(createProdutoDto.getUnidadeMedida());
        produto.setFornecedor(createProdutoDto.getFornecedor());
        produto.setCategoria(createProdutoDto.getCategoria());
        return produtoRepository.save(produto);

    }

    @Override
    public List<Produtos> getProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produtos modificaProduto(CreateProdutoDto createProdutoDto, String id) {
        return null;
    }

    @Override
    public Page<Produtos> findAllPaginated(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    private static final String UPLOAD_DIR = "uploads"; // Directory to store uploaded images
    private static final String THUMBNAIL_DIR = "thumbnails";
    private static final int THUMBNAIL_SIZE = 150; // Thumbnail size (150x150 pixels)

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() {
        createDirectoryIfNotExists(UPLOAD_DIR);
        createDirectoryIfNotExists(THUMBNAIL_DIR);
    }

    private void createDirectoryIfNotExists(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                System.err.println("Failed to create directory: " + directoryName);
            }
        }
    }

    public void addImageToProduto(String produtoId, MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be empty");
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Invalid file type. Only images are allowed.");
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String fileExtension = getFileExtension(originalFileName);
            String newFileName = UUID.randomUUID().toString() + "." + fileExtension;
            Path filePath = Paths.get(UPLOAD_DIR, newFileName);

            Files.copy(file.getInputStream(), filePath);

            String thumbnailFileName = "thumb_" + newFileName;
            generateThumbnail(filePath.toFile(), thumbnailFileName);

            // Save both original and thumbnail file names (or just the original, your choice)
            List<String> imagePaths = new ArrayList<>();
            imagePaths.add(newFileName); // Store original file name
            imagePaths.add(thumbnailFileName); // store thumbnail file name.

            // Update the produto document with the new image paths
            Query query = Query.query(Criteria.where("_id").is(produtoId));
            Update update = new Update().push("imagens").each(imagePaths); //adds both to the array
            mongoTemplate.updateFirst(query, update, Produtos.class);

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload and process image: " + e.getMessage(), e); //wrap
        }
    }



    private void generateThumbnail(File originalImageFile, String newFileName) throws IOException {
        BufferedImage originalImage = ImageIO.read(originalImageFile);
        File thumbnailFile = new File(THUMBNAIL_DIR, newFileName);
        Thumbnails.of(originalImage)
                .size(THUMBNAIL_SIZE, THUMBNAIL_SIZE)
                .keepAspectRatio(true)
                .toFile(thumbnailFile);
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        }
        return "";
    }
}
