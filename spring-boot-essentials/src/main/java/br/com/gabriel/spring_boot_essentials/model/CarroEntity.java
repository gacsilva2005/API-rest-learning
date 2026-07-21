package br.com.gabriel.spring_boot_essentials.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CarroEntity {

    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer potencia;
}
