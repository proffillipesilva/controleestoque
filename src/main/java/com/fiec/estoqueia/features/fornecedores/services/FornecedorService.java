package com.fiec.estoqueia.features.fornecedores.services;

import com.fiec.estoqueia.features.fornecedores.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FornecedorService {
    Fornecedores createFornecedores(CreateFornecedorDto createFornecedorDto);
    List<Fornecedores> getFornecedores();
    List<Fornecedores> getFornecedoresDadoCategoria(ObjectId categoriaId);
    Page<Fornecedores> getFornecedoresPaged(int pageNum, int pageSize, String sortBy, String sortDir);
}
