package com.fiec.estoqueia.features.fornecedores.business.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fiec.estoqueia.business.entities.Endereco;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "fornecedores")
public class Fornecedores {
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;
    private String nome;
    private String cnpj;
    private Endereco endereco;
    private String telefone;
    private String email;
    private Boolean ativo;
}