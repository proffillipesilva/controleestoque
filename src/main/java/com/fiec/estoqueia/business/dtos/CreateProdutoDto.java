package com.fiec.estoqueia.business.dtos;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Map;

@Data
public class CreateProdutoDto {

    private String nome;
    private String descricao;

    private String codigoBarra;
    private ObjectId categoria;

    private Double precoCusto;

    private Double precoVenda;

    private String unidadeMedida;
    private ObjectId fornecedor;


    private Map<String, Object> atributos; // Atributos genéricos

}
