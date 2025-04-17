package com.fiec.estoqueia.features.produtos.controllers;

import com.fiec.estoqueia.features.produtos.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.features.produtos.business.entities.Produtos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProdutoController {
    @PostMapping
    ResponseEntity<Produtos> createProduto(@RequestBody CreateProdutoDto createProdutoDto);

    @GetMapping
    ResponseEntity<List<Produtos>> getProdutos();

    @GetMapping("/paged")
    Page<Produtos> getProdutosPaginated(   @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "nome") String sortBy,
                                           @RequestParam(defaultValue = "asc") String sortDir);
}
