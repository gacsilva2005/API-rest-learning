package br.com.gabriel.spring_boot_essentials.service;

import br.com.gabriel.spring_boot_essentials.dto.CarroDTO;
import br.com.gabriel.spring_boot_essentials.dto.ProdutoDTO;
import br.com.gabriel.spring_boot_essentials.exception.NotFoundException;
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

    //Método para criação de novo objeto, passando o DTO como parâmetro para obter os dados
    public CarroEntity createCarro(CarroDTO carroDTO){

        //Função para incrementar o id na criação do produto
        Integer identificador = CARROS.stream() //transforma a lista em stream pra filtrar
                .mapToInt(CarroEntity::getId) //cada objeto vira seu respectivo ID
                .max() //acha o maior ID
                .orElse(0) + 1; /** adiciona 1 no maior ID para gerar o próximo se
                                        existir algum objeto, se não, o máximo é 0**/

        //Passa os fields do DTO e cria uma nova entidade
        CarroEntity novoCarro = CarroEntity.builder()
                .id(identificador) //passa o id como parâmetro pra construção do objeto
                .nome(carroDTO.getNome()) //GET nome do DTO
                .preco(carroDTO.getPreco()) //GET preco do DTO
                .potencia(carroDTO.getPotencia()) //GET potencia do DTO
                .build(); //builda nova entidade

        //Adiciona novo carro na lista mockada de dados
        CARROS.add(novoCarro);

        //retorna o novo carro criado
        return novoCarro;
    }

    public CarroEntity updateCarro(CarroDTO carroDTO, Integer id) throws Exception {

        //Procura o produto filtrando pelo ID
        CarroEntity carro = CARROS.stream()//transforma a lista em stream pra filtrar
                .filter(p -> p.getId().equals(id))//filtra com o id passado
                .findAny() //pega o que foi encontrado com o ID, se não cai na linha abaixo
                .orElseThrow(() -> new Exception("Carro não encontrado"));

        //Atualiza os fields do produto encotrado pelo ID
        carro.setNome(carro.getNome()); //atualiza o campo com o nome passado
        carro.setPreco(carro.getPreco()); //atualiza o campo com o preco passado
        carro.setPotencia(carro.getPotencia()); //atualiza o campo com a potencia passada

        //retorna a entidade atualizada
        return carro;
    }

    //Método para remover um carro da lista se existir um ID igual já adicionado
    public void deleteCarro(Integer id) {
        //Remove da lista de acordo com o id passado
        CARROS.removeIf(p -> p.getId().equals(id));
    }
}
