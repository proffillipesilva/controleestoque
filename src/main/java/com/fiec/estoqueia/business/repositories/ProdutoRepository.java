package com.fiec.estoqueia.business.repositories;

import com.fiec.estoqueia.business.entities.Produtos;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produtos, ObjectId> {
}