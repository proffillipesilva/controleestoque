package com.fiec.estoqueia.features.produtos.business.repositories;

import com.fiec.estoqueia.features.produtos.business.entities.Produtos;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produtos, ObjectId> {
}