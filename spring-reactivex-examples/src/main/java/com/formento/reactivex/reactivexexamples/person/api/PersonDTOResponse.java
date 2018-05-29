package com.formento.reactivex.reactivexexamples.person.api;


import com.formento.reactivex.reactivexexamples.person.Person;

import java.io.Serializable;
import java.util.UUID;

class PersonDTOResponse implements Serializable {

    private final String id;
    private final String name;
    private final Integer age;

    public PersonDTOResponse(final Person person) {
        this.id = person.getId().map(UUID::toString).orElse(null);
        this.name = person.getName();
        this.age = person.getAge();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}
