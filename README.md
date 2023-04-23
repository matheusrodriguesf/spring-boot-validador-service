# Validador de Documentos

Serviço de de validação de documentos (CPF, CNPJ e Titulor de Eleitor).

Recebe como parâmetro o valor de um documento e retonar se é um documento válido ou inválido 

# Desenvolvimento
## Tecnologias
- Docker
- Java 17
- Spring-boot:3.0.6

## Executando o aplicativo localmente
A aplicação é construida a partir do maven. Para executar o projeto:
```
mvn spring-boot:run
``` 
## Executando o aplicativo via Docker

Realizar o build da image

```
docker build -t matheusrodriguesf/validador-service .
```
Para executar o contêiner

```
docker run -p 8080:8080 --name cep-service matheusrodriguesf/validador-service
```

## Como Usar:

### Requisição

Realizar uma requisição do tipo GET para o endpoint.

```
/validadores/cpf/000.000.000-00
```

```
/validadores/cnpj/00000000000-00
```

```
/validadores/titulo-eleitor/000000000000
```

### Resposta
```
{
  "message": "CPF inválido",
  "valid": false
}
```

## Autor
Matheus Rodrigues

