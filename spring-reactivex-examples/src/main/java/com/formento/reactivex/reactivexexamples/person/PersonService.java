package com.formento.reactivex.reactivexexamples.person;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(final PersonRepository repository) {
        this.repository = repository;
    }

    public Mono<Person> getPersonById(final UUID id) {
        return repository.getPersonById(id);
    }

    public Mono<UUID> create(final Mono<Person> person) {
        return repository.create(person);
    }

}
