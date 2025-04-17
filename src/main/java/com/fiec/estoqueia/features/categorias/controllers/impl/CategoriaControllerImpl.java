package com.fiec.estoqueia.features.categorias.controllers.impl;

import com.fiec.estoqueia.features.categorias.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.features.categorias.business.entities.Categorias;
import com.fiec.estoqueia.features.categorias.controllers.CategoriaController;
import com.fiec.estoqueia.features.categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaControllerImpl implements CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categorias> createCategoria(@RequestBody CreateCategoriaDto createCategoriaDto){
        Categorias categoria = categoriaService.createCategoria(createCategoriaDto);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categorias>> getCategorias() throws InterruptedException {
        //.sleep(5000);
        return ResponseEntity.ok(categoriaService.getCategorias());
    }
}
