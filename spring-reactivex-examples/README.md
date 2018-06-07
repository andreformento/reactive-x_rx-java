# Spring reactivex examples

## Requirements

- Java 10

## How to do

- Run `JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9779 ./gradlew bootRun`
- Create a person
```shell
curl -X POST -H "Content-Type: application/json"\
     -d '{"name": "Formento", "age": 27}' \
     "localhost:9778/people"
```
- Get a person `curl -X GET "localhost:9778/people/uuid123"`

## References

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-why-reactive
