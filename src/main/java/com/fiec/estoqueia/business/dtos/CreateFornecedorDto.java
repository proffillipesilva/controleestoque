package com.fiec.estoqueia.business.dtos;

import com.fiec.estoqueia.business.entities.Endereco;
import lombok.Data;

@Data
public class CreateFornecedorDto {
    private String nome;
    private String cnpj;
    private Endereco endereco;
    private String telefone;
    private String email;
}
