# cloud-parking
Projeto final em Spring do **Bootcamp Québec Java** na DIO.

Você pode acessar e testar a aplicação [aqui](https://rcba-cloud-parking.herokuapp.com/swagger-ui.html), usando o usuário informado abaixo.


## Usuário padrão para acesso ao Swagger

login: user

senha: 12345

link localhost: http://localhost:8080/swagger-ui.html

## Para rodar o banco no Docker
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

## Start e Stop

### Stop Database
docker stop parking-db

### Start Database
docker start parking-db
