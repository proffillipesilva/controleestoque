package com.fiec.estoqueia.features.fornecedores.services.impl;

import com.fiec.estoqueia.features.fornecedores.business.dtos.CreateFornecedorDto;
import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import com.fiec.estoqueia.features.fornecedores.business.repositories.CustomFornecedorRepository;
import com.fiec.estoqueia.features.fornecedores.business.repositories.FornecedorRepository;
import com.fiec.estoqueia.features.fornecedores.services.FornecedorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    CustomFornecedorRepository customFornecedorRepository;

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

    @Override
    public List<Fornecedores> getFornecedoresDadoCategoria(ObjectId categoriaId) {
        return customFornecedorRepository.findFornecedoresByCategoria(categoriaId);
    }

    @Override
    public Page<Fornecedores> getFornecedoresPaged(int pageNum, int pageSize, String sortBy, String sortDir) {
        return customFornecedorRepository.findFornecedoresPaged(pageNum, pageSize, sortBy, sortDir);
    }
}
