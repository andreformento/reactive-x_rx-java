# Spring reactivex examples

## Requirements

- Java 10

## How to do

- Run `./gradlew bootRun`
- Create a person
```shell
curl -X POST -H "Content-Type: application/json"\
     -d '{"name": "Formento", "age": 27}' \
     "localhost:8081/persons"
```
- Get a person `curl -X GET "localhost:8081/persons/uuid123"`

## References

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-why-reactive
