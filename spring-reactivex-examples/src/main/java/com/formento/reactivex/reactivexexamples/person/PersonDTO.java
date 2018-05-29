package com.formento.reactivex.reactivexexamples.person;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class PersonDTO implements Serializable {

    private final String id;
    private final String name;
    private final Integer age;

    @ConstructorProperties({"id", "name", "age"})
    public PersonDTO(final String id, final String name, final Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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
