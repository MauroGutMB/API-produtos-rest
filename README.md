# ApiProdutos

API REST de cadastro de produtos feita com Spring Boot, JPA e SQLite.

Atividade da disciplina **Programação para Internet 2** - Análise e Desenvolvimento de Sistemas, Módulo 4
Instituto Federal do Piauí (IFPI) - Campus Corrente
Professor: Misael Costa
Aluno: Mauro Gutemberg Magalhães Barros

## Tecnologias

- Java 27
- Spring Boot 4.1.1 (Web MVC + Data JPA)
- SQLite (arquivo em `data/apiProdutos.db`)
- Maven

## Como executar

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`. As tabelas são criadas automaticamente

## Modelo

```json
{
  "id": 1,
  "nome": "Teclado",
  "categoria": "Periféricos",
  "preco": 150.0
}
```

## Endpoints

Base: `/produtos`

| Método | Rota | Descrição |
| --- | --- | --- |
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca produto por id |
| GET | `/produtos/nome/{nome}` | Busca produto por nome |
| GET | `/produtos/categoria/{categoria}` | Lista produtos de uma categoria |
| GET | `/produtos/preco?minPreco=10&maxPreco=100` | Lista produtos em uma faixa de preço |
| POST | `/produtos` | Cadastra um produto |
| POST | `/produtos/lista` | Cadastra vários produtos |
| PUT | `/produtos` | Atualiza um produto (id no corpo) |
| DELETE | `/produtos/{id}` | Remove produto por id |
| DELETE | `/produtos/nome/{nome}` | Remove produto por nome |
| DELETE | `/produtos/preco?minPreco=10&maxPreco=100` | Remove produtos em uma faixa de preço |

## Collection do Postman

O arquivo [`ApiProdutos.postman_collection.json`](ApiProdutos.postman_collection.json)
contém uma collection do Postman com todos os endpoints já prontos (apontando para
`http://localhost:8080`).

## Exemplos

Cadastrar um produto:

```bash
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Teclado","categoria":"Periféricos","preco":150.0}'
```

Listar todos:

```bash
curl http://localhost:8080/produtos
```

## Estrutura

```
src/main/java/api/produtos/ifpi/ApiProdutos/
├── controller/   ProdutoController — rotas REST
├── services/     ProdutoServices — interface de serviço
├── impl/         ProdutoImpl — regras de negócio
├── repository/   ProdutoRepository — acesso a dados (JPA)
└── model/        Produto — entidade
```
