package com.fiec.estoqueia.features.produtos.services.impl;

import com.fiec.estoqueia.features.produtos.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.features.produtos.business.entities.Produtos;
import com.fiec.estoqueia.features.produtos.business.repositories.ProdutoRepository;
import com.fiec.estoqueia.features.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
