package br.com.gabriel.spring_boot_essentials.controller;

import br.com.gabriel.spring_boot_essentials.dto.CarroDTO;
import br.com.gabriel.spring_boot_essentials.dto.ProdutoDTO;
import br.com.gabriel.spring_boot_essentials.exception.NotFoundException;
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

    //Método Put para atualizar a lista de itens
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarroEntity updateCarro(@PathVariable Integer id,
                                       @RequestBody CarroDTO carroDTO) throws Exception {
        return carroService.updateCarro(carroDTO, id);
    }

    //Método Delete para excluir um item pelo ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarro(@PathVariable Integer id) {
        carroService.deleteCarro(id);
    }
}
