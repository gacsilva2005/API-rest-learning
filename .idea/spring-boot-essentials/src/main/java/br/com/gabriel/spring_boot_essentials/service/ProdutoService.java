package br.com.gabriel.spring_boot_essentials.service;

import org.springframework.stereotype.Service;

import br.com.gabriel.spring_boot_essentials.model.ProdutoEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    //Simula um banco de dados mockado
    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .nome("Notebook")
                .preco(new BigDecimal(5000))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .nome("Iphone")
                .preco(new BigDecimal(7000))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(3)
                .nome("Mouse")
                .preco(new BigDecimal(500))
                .quantidade(10)
                .build());
    }

    //Método para listar todos os produtos
    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }
}
