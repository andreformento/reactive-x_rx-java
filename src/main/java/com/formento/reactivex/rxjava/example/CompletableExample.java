package com.formento.reactivex.rxjava.example;

import io.reactivex.Completable;

public class CompletableExample {

    public static class Basic {
        public static void main(String... args) {
            Completable completable = Completable.complete();

            completable.subscribe(() -> System.out.println("Completed..."));

            /*
            output:

            Completed...
            */
        }
    }

    public static class OnError {
        public static void main(String... args) {
            Completable completable = Completable.error(new RuntimeException("oops..."));

            completable.subscribe(() -> System.out.println("Completed..."), Throwable::printStackTrace); //o segundo parâmetro é a ação que deverá ser realizada em caso de erro (um Consumer que recebe um Throwable)

            /*
            output:

            java.lang.RuntimeException: oops...
            */
        }
    }

    public static class NoError {
        public static void main(String... args) {
            Completable completable = Completable.fromAction(() -> {
            /* aqui você poderia executar alguma ação como invocar uma API externa, persistir alguma informação, etc.
               ou qualquer outra tarefa onde você não precisa de algum valor de retorno,
               mas precisa reagir caso ocorra algum erro ou quando essa ação seja concluída
            */
            });

            completable.subscribe(() -> System.out.println("Ok...a ação terminou sem erros."), Throwable::printStackTrace);
        }
    }


}
