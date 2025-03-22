package com.fiec.estoqueia.business.repositories;

import com.fiec.estoqueia.business.entities.Categorias;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categorias, ObjectId> {
}