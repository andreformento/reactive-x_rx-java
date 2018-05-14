package com.formento.reactivex.rxjava.example;

import io.reactivex.Single;

public class SingleExample {

    public static class Basic {
        public static void main(String... args) {
            Single<String> single = Single.just("one");

            single.subscribe(System.out::println);

            /*
            output:

            one
            */
        }
    }

    public static class OnError {
        public static void main(String... args) {
            Single<String> single = Single.error(new RuntimeException("oops..."));

            single.subscribe(System.out::println, Throwable::printStackTrace);
            /*
            output:

            java.lang.RuntimeException: oops...
            */
        }
    }


}
