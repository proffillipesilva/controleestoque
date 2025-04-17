package com.fiec.estoqueia.features.categorias.business.repositories;

import com.fiec.estoqueia.features.categorias.business.entities.Categorias;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categorias, ObjectId> {
}