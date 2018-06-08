package com.formento.reactivex.reactivexexamples.person;

import java.util.Optional;
import java.util.UUID;

public class Person {

    private final Optional<UUID> id;
    private final String name;
    private final Integer age;
    private final String sort;

    public Person(final String name, final Integer age, String sort) {
        this.id = Optional.empty();
        this.name = name;
        this.age = age;
        this.sort = sort;
    }

    public Person(final UUID id, final Person person) {
        this.id = Optional.of(id);
        this.name = person.name;
        this.age = person.age;
        this.sort = person.sort;
    }

    public Optional<UUID> getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSort() {
        return sort;
    }
}
