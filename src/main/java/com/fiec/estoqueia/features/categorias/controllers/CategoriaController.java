package com.fiec.estoqueia.features.categorias.controllers;

import com.fiec.estoqueia.features.categorias.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.features.categorias.business.entities.Categorias;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoriaController {
    @PostMapping
    ResponseEntity<Categorias> createCategoria(@RequestBody CreateCategoriaDto createCategoriaDto);

    @GetMapping
    ResponseEntity<List<Categorias>> getCategorias() throws InterruptedException;
}
