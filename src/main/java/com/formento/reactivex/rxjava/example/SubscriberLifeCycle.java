package com.formento.reactivex.rxjava.example;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class SubscriberLifeCycle {
    public static class Basic {
        public static void main(String... args) throws InterruptedException {
            Observable<Long> observable = Observable.interval(1000, TimeUnit.MILLISECONDS);

            observable.subscribe(System.out::println);

            Thread.sleep(5000);

            /*
            output:

            0
            1
            2
            3
            4
            */
        }
    }

}
