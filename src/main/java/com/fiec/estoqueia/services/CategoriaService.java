package com.fiec.estoqueia.services;


import com.fiec.estoqueia.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.business.entities.Categorias;

public interface CategoriaService {
    Categorias createCategoria(CreateCategoriaDto createCategoriaDto);
}
