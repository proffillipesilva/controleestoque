package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.business.entities.Categorias;
import com.fiec.estoqueia.business.entities.Fornecedores;
import com.fiec.estoqueia.services.CategoriaService;
import com.fiec.estoqueia.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    ResponseEntity<Fornecedores> createFornecedor(@RequestBody CreateFornecedorDto createFornecedorDto){
        Fornecedores fornecedor = fornecedorService.createFornecedores(createFornecedorDto);
        return ResponseEntity.ok(fornecedor);
    }
}
