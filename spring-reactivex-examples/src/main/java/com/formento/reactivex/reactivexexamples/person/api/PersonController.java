package com.formento.reactivex.reactivexexamples.person.api;

import java.util.UUID;

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

import com.formento.reactivex.reactivexexamples.person.PersonService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/people")
class PersonController {

    private static final Logger LOGGER = LogManager.getLogger(PersonController.class);

    private final PersonService service;

    PersonController(final PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PersonDTOResponse> getPersonById(final @PathVariable String id) {
        LOGGER.info("Request GET", id);
        return service.
                getPersonById(UUID.fromString(id)).
                map(PersonDTOResponse::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<String> create(final @RequestBody PersonDTORequest personRequest) {
        return service.
                create(personRequest.toModel()).
                map(UUID::toString);
    }

}
