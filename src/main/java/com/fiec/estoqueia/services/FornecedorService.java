package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.business.entities.Fornecedores;

import java.util.List;

public interface FornecedorService {
    Fornecedores createFornecedores(CreateFornecedorDto createFornecedorDto);
    List<Fornecedores> getFornecedores();
}
