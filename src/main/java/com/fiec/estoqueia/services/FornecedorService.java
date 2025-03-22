package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.business.entities.Fornecedores;

public interface FornecedorService {
    Fornecedores createFornecedores(CreateFornecedorDto createFornecedorDto);
}
