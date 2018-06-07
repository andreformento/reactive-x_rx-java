package com.formento.reactivex.reactivexexamples.person;

import java.util.UUID;

import reactor.core.publisher.Mono;

public interface PersonRepository {

    Mono<Person> getPersonById(final UUID id);

    Mono<UUID> create(final Person person);

}
