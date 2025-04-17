package com.fiec.estoqueia.features.produtos.services;

import com.fiec.estoqueia.features.produtos.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.features.produtos.business.entities.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {
    Produtos criaProduto(CreateProdutoDto createProdutoDto);
    List<Produtos> getProdutos();
    Produtos modificaProduto(CreateProdutoDto createProdutoDto, String id);

    Page<Produtos> findAllPaginated(Pageable pageable);
}
