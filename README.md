# Biblioteca de Livros

Este é um sistema simples de gerenciamento de uma biblioteca, onde é possível adicionar, remover e listar livros. O projeto foi desenvolvido em Java e usa o formato JSON para armazenar os dados.

## Funcionalidades

- **Adicionar Livro**: Permite adicionar um livro à biblioteca com informações como nome, autor, descrição e categoria.
- **Remover Livro**: Permite remover um livro da biblioteca com base no seu ID.
- **Listar Livros**: Exibe todos os livros armazenados na biblioteca.

## Requisitos

- Java 8 ou superior
- Biblioteca Gson (para manipulação de JSON)

## Como rodar o projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/GibsonCoutoDev/bibliotecaJava.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd biblioteca
    ```

3. Compile e rode o projeto utilizando um IDE de sua preferência (como IntelliJ IDEA ou Eclipse), ou pelo terminal com o comando:

    ```bash
    javac Main.java
    java Main
    ```

4. O sistema irá solicitar para escolher uma das opções do menu:
    - Adicionar um livro
    - Remover um livro
    - Listar livros
    - Sair

## Estrutura do projeto

- `Main.java`: Classe principal onde o menu interativo e as operações da biblioteca são realizadas.
- `Livros.java`: Classe que representa um livro, com métodos para definir e acessar as propriedades do livro.
- `livros.json`: Arquivo JSON onde os dados dos livros são armazenados.

## Dependências

Este projeto utiliza a biblioteca **Gson** para serialização e desserialização de dados JSON. Para adicioná-la ao seu projeto, baixe o [Gson](https://github.com/google/gson) ou inclua-a no seu `pom.xml` (caso esteja utilizando Maven):

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version>
</dependency>
