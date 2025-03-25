package com.fiec.estoqueia.services;


import com.fiec.estoqueia.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.business.entities.Categorias;

import java.util.List;

public interface CategoriaService {
    Categorias createCategoria(CreateCategoriaDto createCategoriaDto);
    List<Categorias> getCategorias();
}
