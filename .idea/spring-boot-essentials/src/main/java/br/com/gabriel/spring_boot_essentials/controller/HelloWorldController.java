package br.com.gabriel.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

//Criação dos endpoints e passagem de parâmetros apenas
@RestController
@RequestMapping("/v1/hello") //Rota para chamar a API
public class HelloWorldController {

    //    @GetMapping
    //    public String helloWorld(){
    //        return "Hello World";
    //    }

    //Mostra status HTTP para o endpoit criado com o ".ok" ou HTTP 200
    //    @GetMapping
    //    public ResponseEntity<String> helloWorld(){
    //        return ResponseEntity.ok("Hello World");
    //    }

    /**Método Get com passagem do valor id para concaternar no mapping
     * Passagem do HTTP Status no escopo do método
     * Passagem do parâmetro como PathVariable **/
        @GetMapping(value = "/{id}")
        @ResponseStatus(HttpStatus.OK)
        public String get(@PathVariable String id){
            return "Hello World" + id;
        }

}
