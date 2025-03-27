# Projeto GraphQL com Spring

Este é um exemplo básico de como usar **GraphQL** com **Spring Boot** para criar e consultar posts. A ideia do projeto é permitir a criação de posts e a consulta dessas informações via GraphQL.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para criar aplicações Java de forma rápida e fácil.
- **GraphQL**: Linguagem de consulta para APIs que permite consultas flexíveis e eficientes.
- **In-Memory Storage**: Uso de uma estrutura de dados `Map` para armazenar os posts em memória, sem persistência em banco de dados.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **JDK 17** ou superior
- **Maven** ou **Gradle** (para gerenciar dependências)
- **IDE** como IntelliJ IDEA ou Eclipse

## Estrutura do Projeto

A estrutura básica do projeto inclui:

- **Post**: Modelo que representa um post com um conteúdo e um identificador.
- **Comment**: Modelo que representa um comentário associado a um post.
- **GraphQL Schema**: Definição de consultas (queries) e mutações (mutations) para acessar e manipular dados.
- **PostService**: Serviço que lida com a lógica de criação e recuperação de posts e comentários.
- **Controller**: Exposição de endpoints GraphQL.

## Dependências no `pom.xml`

Se estiver utilizando Maven, o arquivo `pom.xml` contém as dependências necessárias:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.graphql-java</groupId>
        <artifactId>graphql-java</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-logging</artifactId>
    </dependency>
    <dependency>
        <groupId>com.graphql-java</groupId>
        <artifactId>graphql-spring-boot-starter</artifactId>
        <version>11.0</version>
    </dependency>
</dependencies>
```

## Configuração do GraphQL

A configuração do GraphQL pode ser feita no arquivo application.properties ou application.yml:

```
graphql.servlet.mapping=/graphql
graphql.servlet.enabled=true
graphql.servlet.corsEnabled=true
```

## Modelos de Dados

### Post

O modelo Post representa um post de blog com um identificador e um conteúdo.

```
public class Post {
    private String id;
    private String content;

    // Getters and Setters
}
```

### Comment

O modelo Comment representa um comentário associado a um post.

```
public class Comment {
    private String id;
    private String content;
    private Post post;

    // Getters and Setters
}
```

## GraphQL Schema

O arquivo schema.graphqls define as consultas e mutações disponíveis:

```
type Post {
    id: ID!
    content: String!
    comments: [Comment]
}

type Comment {
    id: ID!
    content: String!
    postId: String!
}

type Query {
    postById(id: ID!) : Post
    commentById(id: ID!) : Comment
}

type Mutation {
    createPost(content: String!) : Post
    createComment(content: String!, postId: String!) : Comment
}
```

## Consultas

Consulta para obter todos os posts:
```
query {
    posts {
        id
        content
    }
}
```

Consulta para obter um post por ID:

```
query {
    postById(id: "1") {
        id
        content
    }
}
```

Mutações

Criar um novo post:
```
mutation {
    createPost(content: "My first post") {
        id
        content
    }
}
```
Criar um novo comentário em um post:

```
mutation {
    createComment(postId: "1", content: "Great post!") {
        id
        content
        post {
            id
        }
    }
}
```

## Iniciar o Projeto

Clone o repositório:

    git clone https://github.com/seu-usuario/seu-repositorio.git

Navegue até o diretório do projeto:

    cd seu-repositorio

Execute o projeto com Maven:

    mvn spring-boot:run

Ou, se estiver usando Gradle:

    ./gradlew bootRun

O servidor estará rodando em http://localhost:8080.
Testando a API GraphQL

Você pode testar a API GraphQL utilizando o console GraphiQL embutido. Acesse:

http://localhost:8080/graphiql

Isso abrirá a interface onde você pode executar suas consultas e mutações GraphQL diretamente.
