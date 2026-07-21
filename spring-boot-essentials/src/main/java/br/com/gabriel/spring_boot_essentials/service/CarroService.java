package br.com.gabriel.spring_boot_essentials.service;

import br.com.gabriel.spring_boot_essentials.model.CarroEntity;
import br.com.gabriel.spring_boot_essentials.model.ProdutoEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    private static final List<CarroEntity> CARROS  = new ArrayList<>();

    //Injeta dados mockados que futuramente serão substituídos por um DataBase real
    static {
        CARROS.add(CarroEntity.builder()
                //fields
                .id(1) //id da entidade
                .nome("McLaren") //nome
                .preco(new BigDecimal(500000)) //preço
                .potencia(600) //potência em CV
                .build()); //comando para construir a entidade com os parâmetros passados

        CARROS.add(CarroEntity.builder()
                .id(2)
                .nome("TCross")
                .preco(new BigDecimal(100000))
                .potencia(300)
                .build());

        CARROS.add(CarroEntity.builder()
                .id(3)
                .nome("Evoque")
                .preco(new BigDecimal(200000))
                .potencia(450)
                .build());
    }

    //Método para listar todos os produtos
    public List<CarroEntity> findAll() {
        return new ArrayList<>(CARROS);
    }
}
