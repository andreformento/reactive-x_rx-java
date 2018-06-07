package com.formento.reactivex.reactivexexamples.person.api;

import java.beans.ConstructorProperties;
import java.io.Serializable;

import com.formento.reactivex.reactivexexamples.person.Person;

class PersonDTORequest implements Serializable {

    private final String name;
    private final Integer age;

    @ConstructorProperties({"name", "age"})
    PersonDTORequest(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    Person toModel() {
        return new Person(name, age);
    }

}
