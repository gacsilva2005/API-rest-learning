# Spring Boot Essentials - Produto API

  <p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" alt="Java"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="40" alt="Spring Boot"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="40" alt="Maven"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="40" alt="Git"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="40" alt="GitHub"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="40" alt="IntelliJ IDEA"/>
</p>

API REST desenvolvida com **Spring Boot** para gerenciamento de produtos. O projeto foi criado com foco em demonstrar os conceitos fundamentais do desenvolvimento de APIs REST, incluindo CRUD, DTOs, tratamento de exceções e boas práticas de organização.

---

## 📌 Tecnologias

* Java 21
* Spring Boot
* Spring Web
* Lombok
* Maven

---

## 🚀 Funcionalidades

* Criar um produto
* Listar todos os produtos
* Buscar um produto por ID
* Atualizar um produto
* Remover um produto
* Tratamento global de exceções
* Respostas de erro padronizadas

---

## 📂 Estrutura do Projeto

```text
src
 └── main
     ├── controller
     ├── dto
     ├── entity
     ├── exception
     ├── handler
     ├── service
     └── SpringBootEssentialsApplication
```

---

## ▶️ Como executar

### Clone o projeto

```bash
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

### Entre na pasta

```bash
cd SEU-REPOSITORIO
```

### Execute

```bash
./mvnw spring-boot:run
```

Ou execute a classe principal da aplicação pela IDE.

---

## 📡 Endpoints

| Método | Endpoint         | Descrição               |
| ------ | ---------------- | ----------------------- |
| GET    | `/produtos`      | Lista todos os produtos |
| GET    | `/produtos/{id}` | Busca um produto        |
| POST   | `/produtos`      | Cria um produto         |
| PUT    | `/produtos/{id}` | Atualiza um produto     |
| DELETE | `/produtos/{id}` | Remove um produto       |

---

## 📥 Exemplo de Requisição

```http
POST /produtos
Content-Type: application/json
```

```json
{
  "nome": "Notebook",
  "preco": 4500.00
}
```

---

## 📤 Exemplo de Resposta

```json
{
  "id": 1,
  "nome": "Notebook",
  "preco": 4500.00
}
```

---

## ❌ Exemplo de Erro

```json
{
  "message": "Produto não encontrado.",
  "status": 404
}
```

---

## 📄 Licença

Este projeto foi desenvolvido para fins de estudo e aprendizado sobre Spring Boot.
