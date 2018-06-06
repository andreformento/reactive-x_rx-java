package com.formento.reactivex.reactivexexamples.person.api;

import com.formento.reactivex.reactivexexamples.person.PersonService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
@RequestMapping("/people")
class PersonController {

    private static final Logger LOGGER = LogManager.getLogger(PersonController.class);

    private final PersonService service;

    PersonController(final PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Mono<ServerResponse> getPersonById(final @PathVariable String id) {
        LOGGER.info("Request GET", id);
        return service.
                getPersonById(UUID.fromString(id)).
                map(PersonDTOResponse::new).
                flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person))).
                switchIfEmpty(ServerResponse.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<String> create(final @RequestBody Mono<PersonDTORequest> personRequest) {
        return service.
                create(personRequest.map(PersonDTORequest::toModel)).
                map(UUID::toString);
    }

}
