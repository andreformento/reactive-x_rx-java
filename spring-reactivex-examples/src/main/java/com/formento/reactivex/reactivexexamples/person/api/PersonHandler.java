package com.formento.reactivex.reactivexexamples.person.api;

import com.formento.reactivex.reactivexexamples.person.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

// https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux-fn
@Component
public class PersonHandler {

    private final PersonService personService;

    public PersonHandler(final PersonService personService) {
        this.personService = personService;
    }

    public Mono<ServerResponse> getPersonById(ServerRequest request) {
        return personService.getPersonById(UUID.fromString(request.pathVariable("id")))
                .flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findPersonByName(ServerRequest request) {
        return personService.getPersonById(UUID.fromString(request.pathVariable("id")))
                .flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
