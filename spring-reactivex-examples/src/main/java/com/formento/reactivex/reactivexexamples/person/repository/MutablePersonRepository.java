package com.formento.reactivex.reactivexexamples.person.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.formento.reactivex.reactivexexamples.person.Person;
import com.formento.reactivex.reactivexexamples.person.PersonRepository;
import com.formento.reactivex.reactivexexamples.person.infra.PersonNotFoundException;

import reactor.core.publisher.Mono;

@Repository
public class MutablePersonRepository implements PersonRepository {

    private final Map<UUID, Person> storage;

    public MutablePersonRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public Mono<Person> getPersonById(final UUID id) {
        return Optional.
                ofNullable(storage.get(id)).
                map(Mono::just).
                orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Override
    public Mono<UUID> create(final Mono<Person> person) {
        return person.
                map(p -> new Person(UUID.randomUUID(), p)).
                doOnSuccess(p -> storage.put(
                        p.getId().orElseThrow(() -> new RuntimeException("Oh Lord!")),
                        p
                        )
                ).
                map(p -> p.
                        getId().
                        orElseThrow(() -> new RuntimeException("What there is not id???"))
                );
    }

}
