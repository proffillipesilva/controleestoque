package com.fiec.estoqueia.business.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
public class Usuarios {
    @Id
    private ObjectId id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;
    private Boolean ativo;
}