package com.fiec.estoqueia.features.fornecedores.business.repositories.impl;

import com.fiec.estoqueia.features.fornecedores.business.entities.Fornecedores;
import com.fiec.estoqueia.features.fornecedores.business.repositories.CustomFornecedorRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomFornecedorRepositoryImpl implements CustomFornecedorRepository {


    private MongoTemplate mongoTemplate;

    public CustomFornecedorRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<Fornecedores> findFornecedoresPaged(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Query query = new Query()
                .with(pageable); // Adds skip and limit based on Pageable

        long total = mongoTemplate.count(query, Fornecedores.class);
        List<Fornecedores> fornecedores = mongoTemplate.find(query, Fornecedores.class);

        return new PageImpl<>(fornecedores, pageable, total);
    }

    @Override
    public List<Fornecedores> findFornecedoresByCategoria(ObjectId categoriaId) {
        // Define the aggregation pipeline stages.
        AggregationOperation matchStage = Aggregation.match(org.springframework.data.mongodb.core.query.Criteria.where("categoria").is(categoriaId));  // Filter products by categoria
        AggregationOperation lookupStage = Aggregation.lookup("fornecedores", "fornecedor", "_id", "fornecedores"); // Join with fornecedores collection
        AggregationOperation unwindStage = Aggregation.unwind("fornecedores"); // Deconstruct the fornecedores array
        AggregationOperation groupStage = Aggregation.group("fornecedores").first("fornecedores").as("fornecedor"); // Group by fornecedor and get the first one.
        AggregationOperation replaceRootStage = Aggregation.replaceRoot("fornecedor"); // Replace the root document with the fornecedor document.


        // Create the aggregation pipeline.
        Aggregation aggregation = Aggregation.newAggregation(matchStage, lookupStage, unwindStage, groupStage, replaceRootStage);

        // Execute the aggregation and map the results to Fornecedores class.
        List<Fornecedores> results = mongoTemplate.aggregate(aggregation, "produtos", Fornecedores.class).getMappedResults();
        return results;
    }
}
