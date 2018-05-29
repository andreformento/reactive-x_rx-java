package com.formento.reactivex.reactivexexamples.person.repository;

import com.formento.reactivex.reactivexexamples.person.Person;
import com.formento.reactivex.reactivexexamples.person.PersonRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
                orElseGet(Mono::empty);
    }

    @Override
    public Mono<UUID> create(final Mono<Person> person) {
        return person.
                map(p -> new Person(UUID.randomUUID(), p)).
                doOnSuccess(p -> storage.put(p.getId().orElseThrow(() -> new RuntimeException("Oh Lord!")), p)).
                map(p -> p.getId().orElseThrow(() -> new RuntimeException("What there is not id???")));
    }

}
