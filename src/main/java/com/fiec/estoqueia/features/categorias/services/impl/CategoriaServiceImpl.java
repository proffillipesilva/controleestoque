package com.fiec.estoqueia.features.categorias.services.impl;

import com.fiec.estoqueia.features.categorias.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.features.categorias.business.entities.Categorias;
import com.fiec.estoqueia.features.categorias.business.repositories.CategoriaRepository;
import com.fiec.estoqueia.features.categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categorias createCategoria(CreateCategoriaDto createCategoriaDto) {
        Categorias categorias = new Categorias();
        categorias.setNome(createCategoriaDto.getNome());
        categorias.setDescricao(createCategoriaDto.getDescricao());
        categorias.setIcon(createCategoriaDto.getIcon());
        return categoriaRepository.save(categorias);
    }

    @Override
    public List<Categorias> getCategorias() {
        return categoriaRepository.findAll();
    }
}
