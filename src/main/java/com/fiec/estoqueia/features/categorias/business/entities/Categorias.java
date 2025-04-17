package com.fiec.estoqueia.features.categorias.business.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "categorias")
public class Categorias {
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;
    private String nome;
    private String descricao;
    private String icon;
    private Boolean ativo;
}