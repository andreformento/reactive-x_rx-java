package com.formento.reactivex.rxjava.whateverpipeline;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Collection;

public class WhateverApplication {

    public static void main(String... args) {
        Observable<String> source = Observable.just("Smartphone");

        Collection<Stage> stages = new ArrayList<>();
        stages.add(String::toUpperCase);
        stages.add(param -> "The product is " + param);

        Observable<String> newObservable = stages
                .stream()
                .reduce(source, (observable, stage) -> observable.map(stage::whatever), (a, b) -> a);

        newObservable.subscribe(System.out::println);
    }

    private interface Stage {
        String whatever(String parameter);
    }

}
