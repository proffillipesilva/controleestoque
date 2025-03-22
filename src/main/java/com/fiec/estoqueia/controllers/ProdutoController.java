package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.business.entities.Produtos;
import com.fiec.estoqueia.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    ResponseEntity<Produtos> createProduto(@RequestBody CreateProdutoDto createProdutoDto){
        Produtos produto = produtoService.criaProduto(createProdutoDto);
        return ResponseEntity.ok(produto);
    }
}
