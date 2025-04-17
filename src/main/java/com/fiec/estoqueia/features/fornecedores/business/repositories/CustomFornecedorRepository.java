package com.fiec.estoqueia.features.fornecedores.business.repositories;

import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomFornecedorRepository {
    Page<Fornecedores> findFornecedoresPaged(int page, int size, String sortBy, String sortDir);

    List<Fornecedores> findFornecedoresByCategoria(ObjectId categoriaId);
}
