package com.fiec.estoqueia.business.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "usuarios")
public class Usuarios {
    @Id
    private ObjectId id;
    private String nome;
    private String email;
    private String password;
    private String perfil;
    private Boolean ativo;

    private String fbToken;
    private Date lastLogin;
    private Role role;

    public enum Role {
        ADMIN, STANDARD
    }
}