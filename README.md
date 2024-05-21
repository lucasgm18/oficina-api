# 🚗 Oficina de Carros API

## 📜 Introdução

Este projeto tem como objetivo desenvolver uma API REST Java que consome recursos de outra API, integrando-se ao projeto integrador. A API permitirá gerenciar informações de veículos, como VIN (Vehicle Identification Number) e placa.

## 🎯 Objetivos

- Desenvolver uma API REST Java.
- Integrar a API ao projeto integrador.

## 📚 Índice

- [Recursos](#recursos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Controle de Versão](#controle-de-versão)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Testes](#testes)
- [Divisão de Responsabilidades](#divisão-de-responsabilidades)
- [Endpoints](#endpoints)
  - [Consultar todos os carros](#consultar-todos-os-carros)
  - [Cadastrar um novo carro](#cadastrar-um-novo-carro)
  - [Alterar a placa de um carro](#alterar-a-placa-de-um-carro)
- [Como Executar](#como-executar)
- [Licença](#licença)
- [Contato](#contato)

## 🛠 Recursos

- Consultar todos os carros.
- Cadastrar um novo carro.
- Alterar a placa de um carro.

## 🎧 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5
- PostgreSQL
- Swagger
- Maven
- Logger
- Spring JPA, tools e web
- Git


## 📂 Estrutura do Projeto

A `divisão` de camadas do projeto será:
- `Controller`
- `Service`
- `Repository`
- `Model`


## 🔍 Endpoints

### Consultar todos os carros

- **Rota:** `GET /carros`
- **Descrição:** Retorna uma lista de todos os carros `cadastrados` na `oficina`.

![resultado rota get](https://github.com/lucasgm18/oficina-api/assets/127359287/ce05c88e-01e4-4d65-9dd4-d3d47b8cb211)

---

### Cadastrar um novo carro

- **Rota:** `POST /carros`
- **Descrição:** Cadastra um `novo` carro na oficina.
- **Exemplo de Cadastro:**

![rota post swagger](https://github.com/lucasgm18/oficina-api/assets/127359287/0c43005b-d6a3-4667-9973-c7011afbcbd4)


---

### Alterar a placa de um carro

- **Rota:** `PUT /carros/{vin}`
- **Descrição:** Altera a `placa` de um carro existente identificado pelo VIN.
- **Parâmetros de Rota:**
  - `vin`: O número de identificação do veículo.
- **Exemplo de Alteração:**

![ROTA PUT PT1](https://github.com/lucasgm18/oficina-api/assets/127359287/cc9ce197-4a32-401f-a73e-9c1c44dfff09)

![ROTA PUT PT2](https://github.com/lucasgm18/oficina-api/assets/127359287/62c262c0-5766-4aa8-933b-dcdffff1ec14)



## 🚀 Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/lucasgm18/oficina-carros-api.git

Navegue até o diretório do projeto:
cd oficina-carros-api


Compile e execute a aplicação:
./mvnw spring-boot:run


📄 Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalais.



---
