package com.fiec.estoqueia.features.fornecedores.business.repositories;

import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedores, ObjectId> {
}