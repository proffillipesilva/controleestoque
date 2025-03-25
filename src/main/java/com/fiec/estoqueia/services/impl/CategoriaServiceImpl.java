package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.dtos.CreateCategoriaDto;
import com.fiec.estoqueia.business.entities.Categorias;
import com.fiec.estoqueia.business.repositories.CategoriaRepository;
import com.fiec.estoqueia.services.CategoriaService;
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
        return categoriaRepository.save(categorias);
    }

    @Override
    public List<Categorias> getCategorias() {
        return categoriaRepository.findAll();
    }
}
