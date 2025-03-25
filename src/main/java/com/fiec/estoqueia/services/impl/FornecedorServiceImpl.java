package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.business.entities.Fornecedores;
import com.fiec.estoqueia.business.repositories.FornecedorRepository;
import com.fiec.estoqueia.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedores createFornecedores(CreateFornecedorDto createFornecedorDto) {
        Fornecedores fornecedor = new Fornecedores();
        fornecedor.setCnpj(createFornecedorDto.getCnpj());
        fornecedor.setNome(createFornecedorDto.getNome());
        fornecedor.setEmail(createFornecedorDto.getEmail());
        fornecedor.setEndereco(createFornecedorDto.getEndereco());

        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedores> getFornecedores() {
        return fornecedorRepository.findAll();
    }
}
