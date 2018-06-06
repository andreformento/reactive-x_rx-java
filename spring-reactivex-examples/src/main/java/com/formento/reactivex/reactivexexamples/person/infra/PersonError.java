package com.formento.reactivex.reactivexexamples.person.infra;

import java.io.Serializable;

class PersonError implements Serializable {

    private final String id;
    private final String message;

    PersonError(final String id, final String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
