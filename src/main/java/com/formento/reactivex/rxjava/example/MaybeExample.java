package com.formento.reactivex.rxjava.example;

import io.reactivex.Maybe;

public class MaybeExample {

    public static class Basic {
        public static void main(String... args) {
            Maybe<String> maybe = Maybe.just("any value");

            maybe.subscribe(System.out::println); //onSuccess

            /*
            output:

            any value
            */
        }
    }

    public static class OnError {
        public static void main(String... args) {
            Maybe<String> maybe = Maybe.error(new RuntimeException("oops..."));

            maybe.subscribe(System.out::println, Throwable::printStackTrace);

            /*
            output:

            java.lang.RuntimeException: oops...
            */
        }
    }

    public static class OnEmpty {
        public static void main(String... args) {
            Maybe<String> maybe = Maybe.empty();

            maybe.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed..."));

            /*
            output:

            Completed...
            */
        }
    }

    public static class OnNull {
        public static void main(String... args) {
            /* Esse exemplo demonstra bem a diferença entre um Maybe e um Observable.
               Aqui, estamos criando o Maybe a partir de uma computação que devolve null.
               Nessa situação, o Maybe irá emitir o evento onCompleted, pois não há valor a ser emitido para o onSuccess.
               Já um Observable nunca emite valores nulos (o código abaixo lançaria uma exceção, se fosse um Observable).
            */

            Maybe<String> maybe = Maybe.fromCallable(() -> null);

            maybe.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed..."));

            /*
            output:

            Completed...
            */
        }
    }


}
