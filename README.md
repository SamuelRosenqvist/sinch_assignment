# Sinch Assignment

- Problem 1: Pairs in an array with a given sum.
- Problem 2: Parsing for Polish notation mathematical expressions.
- Problem 3: RESTful API for the Polish notation parser implemented with Spring Boot.  

***
The project can be built with maven.


JUnit tests and input files provided for problems 1 & 2.

***
To start API locally call:
```
./mvnw clean spring-boot:run
```

API commands, examples:
```
GET: $ curl -v localhost:8080/expressions

POST: $ curl -X POST localhost:8080/expressions -H 'Content-type:application/json' -d '{"expr": "+ 1 2"}'

PUT: $ curl -X PUT localhost:8080/expressions/2 -H 'Content-type:application/json' -d '{"expr": "- + 10 1 6"}'

DELETE: $ curl -X DELETE localhost:8080/expressions/1
```
