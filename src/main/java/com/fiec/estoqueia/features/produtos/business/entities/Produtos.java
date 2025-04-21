package com.fiec.estoqueia.features.produtos.business.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "produtos")
public class Produtos {
    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;
    private String nome;
    private String descricao;
    @Field("codigo_barra")
    private String codigoBarra;
    private ObjectId categoria;
    @Field("preco_custo")
    private Double precoCusto;
    @Field("preco_venda")
    private Double precoVenda;
    @Field("unidade_medida")
    private String unidadeMedida;
    private ObjectId fornecedor;
    private List<String> imagens;
    private Boolean ativo;
    @CreatedDate
    @Field("data_cadastro")
    private Date dataCadastro;
    private Map<String, Object> atributos; // Atributos genéricos
}