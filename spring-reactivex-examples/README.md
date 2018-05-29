# Spring reactivex examples

## Examples

- Run `./gradlew bootRun`
- Get a person `curl -X GET "localhost:8081/persons/uuid123"`
- Create a person
```shell
curl -X POST -H "Content-Type: application/json"\
     -d '{"name": "Formento", "age": 27}' \
     "localhost:8081/persons"
```

## References

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-why-reactive
