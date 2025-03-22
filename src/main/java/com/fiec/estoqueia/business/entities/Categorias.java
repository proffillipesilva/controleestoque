package com.fiec.estoqueia.business.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "categorias")
public class Categorias {
    @Id
    private ObjectId id;
    private String nome;
    private String descricao;
    private Boolean ativo;
}