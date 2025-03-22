package com.fiec.estoqueia.business.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "estoque")
public class Estoque {
    @Id
    private ObjectId id;
    private ObjectId produto;
    private Double quantidade;
    private String localizacao;
    private String lote;
    @Field("data_validade")
    private Date dataValidade;
}