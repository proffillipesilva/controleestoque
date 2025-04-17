package com.fiec.estoqueia.features.fornecedores.controllers;

import com.fiec.estoqueia.features.fornecedores.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FornecedorController {

    @PostMapping
    ResponseEntity<Fornecedores> createFornecedor(@RequestBody CreateFornecedorDto createFornecedorDto);

    @GetMapping
    ResponseEntity<List<Fornecedores>> getFornecedores();

    @GetMapping("/paged")
    public Page<Fornecedores> getFornecedoresPaged(@RequestParam String status,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,
                                                   @RequestParam(defaultValue = "username") String sortBy,
                                                   @RequestParam(defaultValue = "asc") String sortDir);


}
