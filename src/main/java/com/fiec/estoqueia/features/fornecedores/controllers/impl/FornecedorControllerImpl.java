package com.fiec.estoqueia.features.fornecedores.controllers.impl;

import com.fiec.estoqueia.features.fornecedores.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import com.fiec.estoqueia.features.fornecedores.controllers.FornecedorController;
import com.fiec.estoqueia.features.fornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorControllerImpl implements FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedores> createFornecedor(@RequestBody CreateFornecedorDto createFornecedorDto){
        Fornecedores fornecedor = fornecedorService.createFornecedores(createFornecedorDto);
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedores>> getFornecedores(){
        return ResponseEntity.ok(fornecedorService.getFornecedores());
    }

    @GetMapping("/paged")
    public Page<Fornecedores> getFornecedoresPaged(@RequestParam String status,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size,
                                               @RequestParam(defaultValue = "username") String sortBy,
                                               @RequestParam(defaultValue = "asc") String sortDir) {

        /*Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return fornecedorRepository.findAll(pageable);
        */


        return fornecedorService.getFornecedoresPaged(page, size, sortBy, sortDir);
    }
}
