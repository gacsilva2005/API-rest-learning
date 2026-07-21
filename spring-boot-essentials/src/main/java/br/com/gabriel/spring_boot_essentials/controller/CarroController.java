package br.com.gabriel.spring_boot_essentials.controller;

import br.com.gabriel.spring_boot_essentials.dto.CarroDTO;
import br.com.gabriel.spring_boot_essentials.dto.ProdutoDTO;
import br.com.gabriel.spring_boot_essentials.model.CarroEntity;
import br.com.gabriel.spring_boot_essentials.model.ProdutoEntity;
import br.com.gabriel.spring_boot_essentials.service.CarroService;
import br.com.gabriel.spring_boot_essentials.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//beens do Spring Boot
@RestController
@RequestMapping("/v1/carros")
@RequiredArgsConstructor
public class CarroController {

    //Injetando a classe que vai fornecer os métodos
    private final CarroService carroService;

    //Método Get para puxar todos os itens da lista
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarroEntity> findAll(){
        return carroService.findAll();
    }

    //Método Post para adicional novo carro na lista
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarroEntity createCarro(@RequestBody CarroDTO carroDTO) {
        return carroService.createCarro(carroDTO);
    }
}
