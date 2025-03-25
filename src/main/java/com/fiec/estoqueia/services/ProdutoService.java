package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.business.entities.Produtos;

import java.util.List;

public interface ProdutoService {
    Produtos criaProduto(CreateProdutoDto createProdutoDto);
    List<Produtos> getProdutos();
    Produtos modificaProduto(CreateProdutoDto createProdutoDto, String id);
}
