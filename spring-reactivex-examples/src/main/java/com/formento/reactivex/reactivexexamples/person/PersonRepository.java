package com.formento.reactivex.reactivexexamples.person;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonRepository {

    Mono<Person> getPersonById(final UUID id);

    Mono<UUID> create(final Mono<Person> person);

}
