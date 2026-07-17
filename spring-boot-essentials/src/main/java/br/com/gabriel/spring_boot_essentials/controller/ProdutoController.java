package br.com.gabriel.spring_boot_essentials.controller;

import br.com.gabriel.spring_boot_essentials.model.ProdutoEntity;
import br.com.gabriel.spring_boot_essentials.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.gabriel.spring_boot_essentials.service.ProdutoService;

import java.util.List;

//beens do Spring Boot
@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    //Injetando a classe que vai fornecer os métodos
    private final ProdutoService produtoService;

    //Método Get para puxar todos os itens da lista
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){
        return produtoService.findAll();
    }

    //Método Post para adicional novo item na lista
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduto(@RequestBody ProdutoDTO produtoDto) {
        return produtoService.createProduto(produtoDto);
    }

    //Método Put para atualizar a lista de itens
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity updateProduto(@PathVariable Integer id,
                                       @RequestBody ProdutoDTO produtoDto){
        return produtoService.updateProduto(produtoDto, id);
    }

    //Método Delete para excluir um item pelo ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        produtoService.deleteProduto(id);
    }
}
