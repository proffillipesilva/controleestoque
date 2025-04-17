package com.fiec.estoqueia.features.categorias.services;


import com.fiec.estoqueia.features.categorias.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.features.categorias.business.entities.Categorias;

import java.util.List;

public interface CategoriaService {
    Categorias createCategoria(CreateCategoriaDto createCategoriaDto);
    List<Categorias> getCategorias();
}
