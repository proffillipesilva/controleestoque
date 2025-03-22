package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.dtos.CreateProdutoDto;
import com.fiec.estoqueia.business.entities.Produtos;
import com.fiec.estoqueia.business.repositories.ProdutoRepository;
import com.fiec.estoqueia.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produtos criaProduto(CreateProdutoDto createProdutoDto) {
        Produtos produto = new Produtos();
        produto.setAtributos(createProdutoDto.getAtributos());
        produto.setDescricao(createProdutoDto.getDescricao());
        produto.setCodigoBarra(createProdutoDto.getCodigoBarra());
        produto.setNome(createProdutoDto.getNome());
        produto.setPrecoCusto(createProdutoDto.getPrecoCusto());
        produto.setPrecoVenda(createProdutoDto.getPrecoVenda());
        produto.setUnidadeMedida(createProdutoDto.getUnidadeMedida());
        produto.setFornecedor(createProdutoDto.getFornecedor());
        produto.setCategoria(createProdutoDto.getCategoria());
        return produtoRepository.save(produto);

    }
}
