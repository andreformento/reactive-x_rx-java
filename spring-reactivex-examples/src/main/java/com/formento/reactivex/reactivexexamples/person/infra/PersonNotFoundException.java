package com.formento.reactivex.reactivexexamples.person.infra;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {

    private final UUID id;

    public PersonNotFoundException(final UUID id) {
        this.id = id;
    }

    UUID getId() {
        return id;
    }
}
