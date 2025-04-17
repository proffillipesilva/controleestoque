package com.fiec.estoqueia.features.categorias.business.dtos;

import lombok.Data;

@Data
public class CreateCategoriaDto {
    private String nome;
    private String descricao;
    private String icon;
}
