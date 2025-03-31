package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.business.entities.Fornecedores;
import com.fiec.estoqueia.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    ResponseEntity<List<Fornecedores>> getFornecedores(){
        return ResponseEntity.ok(fornecedorService.getFornecedores());
    }
}
