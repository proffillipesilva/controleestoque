package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.business.entities.Produtos;

public interface ProdutoService {
    Produtos criaProduto(CreateProdutoDto createProdutoDto);
}
