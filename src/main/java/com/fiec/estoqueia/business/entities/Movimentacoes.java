package com.fiec.estoqueia.business.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "movimentacoes")
public class Movimentacoes {
    @Id
    private ObjectId id;
    private ObjectId produto;
    private String tipo;
    private Double quantidade;
    @Field("data_movimentacao")
    private Date dataMovimentacao;
    private ObjectId usuario;
    private String observacoes;
    private String referencia;
}