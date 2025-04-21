package com.fiec.estoqueia.features.produtos.controllers.impl;

import com.fiec.estoqueia.features.produtos.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.features.produtos.business.entities.Produtos;
import com.fiec.estoqueia.features.produtos.services.ProdutoService;
import com.fiec.estoqueia.features.produtos.controllers.ProdutoController;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoControllerImpl implements ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> createProduto(@RequestBody CreateProdutoDto createProdutoDto){
        Produtos produto = produtoService.criaProduto(createProdutoDto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> getProdutos(){
        return ResponseEntity.ok(produtoService.getProdutos());
    }

    @GetMapping("/paged")
    public Page<Produtos> getProdutosPaginated(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size,
                                               @RequestParam(defaultValue = "nome") String sortBy,
                                               @RequestParam(defaultValue = "asc") String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return produtoService.findAllPaginated(pageable);
    }

    @Override
    @PutMapping("/{id}/images")
    public ResponseEntity<Void> uploadImage(@PathVariable("id") String produtoId, @RequestParam("file") MultipartFile file) {
        produtoService.addImageToProduto(produtoId, file);
        return ResponseEntity.ok().build();
    }
}
