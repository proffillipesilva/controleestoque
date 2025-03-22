package com.fiec.estoqueia.business.entities;

import lombok.Data;

@Data
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}