##Requisitos:
- Maven
- Java 8

##Como usar?
1. Clone o repositório.
2. Entre na pasta do projeto pelo terminal e execute: mvn clean install
3. Após concluir o processo de compilação execute: mvn jetty:run

##Observações:
Tentei facilitar o maximo o deploy, então criei o projeto com banco de dados e servidor embarcado. O banco de dados tem o nome "db", o arquivo será criado na pasta pessoal do usuario. Arquivos criados; db.lck, db.log, db.properties, db.script

##Recomendações WebService:
Requisitando a menor Rota
GET http://localhost:8080/walmart-teste/rs/{origem}/{destino}/{autonomia}/{valorDoLitro}
exemplo: http://localhost:8080/walmart-teste/rs/A/D/10/2,50

POST http://localhost:8080/walmart-teste/rs/

Exemplo de requisição para salvar o mapa no banco:
```json
{
   "nome":"Mapa SP",
   "rotas":[
      {
         "origem":"A",
         "destino":"B",
         "distancia":10
      },
      {
         "origem":"B",
         "destino":"D",
         "distancia":15
      },
      {
         "origem":"A",
         "destino":"C",
         "distancia":20
      },
      {
         "origem":"C",
         "destino":"D",
         "distancia":30
      },
      {
         "origem":"B",
         "destino":"E",
         "distancia":50
      },
      {
         "origem":"D",
         "destino":"E",
         "distancia":30
      }
   ]
}
```

##Comentários sobre o exercicio:




