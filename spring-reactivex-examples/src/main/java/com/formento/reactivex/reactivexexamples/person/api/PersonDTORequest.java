package com.formento.reactivex.reactivexexamples.person.api;

import java.beans.ConstructorProperties;
import java.io.Serializable;

import com.formento.reactivex.reactivexexamples.person.Person;

class PersonDTORequest implements Serializable {

    private final String name;
    private final Integer age;
    private final String sort;

    @ConstructorProperties({"name", "age", "sort"})
    PersonDTORequest(final String name, final Integer age, String sort) {
        this.name = name;
        this.age = age;
        this.sort = sort;
    }

    Person toModel() {
        return new Person(name, age, sort);
    }

}
