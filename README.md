<h1 align="center">
  TODO List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=GitHub&message=@DevEmannuelMorais&color=blue&labelColor=000000" alt="DevEmannuelMorais" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=blue&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar uma academia (CRUD).


## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Spring Security 3](https://docs.spring.io/spring-security/reference/whats-new.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Docker](https://docs.docker.com/desktop/install/windows-install/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Aluno
```
$ http POST :8080/alunos nome="String" cpf="string" bairro="string" dataDeNascimento="2023-07-12"

[
  {
    "nome": "string",
    "cpf": "string",
    "bairro": "string",
    "dataDeNascimento": "2023-07-12"
  }
]
```

- Listar Alunos
```
$ http GET :8080/alunos

[
  {
    "id": 0,
    "nome": "string",
    "cpf": "string",
    "bairro": "string",
    "dataDeNascimento": "2023-07-12"
  }
]
```

- Atualizar Aluno
```
$ http PUT :8080/aluno/{id}

[
  {
  "nome": "string",
  "bairro": "string",
  "dataDeNascimento": "2023-07-12"
  }
]
```

- Remover Aluno
```
http DELETE :8080/alunos/1

[ ]
```
