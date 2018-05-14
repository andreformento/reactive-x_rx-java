package com.formento.reactivex.rxjava.example;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObservableExample {

    public static class Basic {
        public static void main(String... args) {
            Observable<String> observable = Observable.just("one", "two", "three");

            observable.subscribe(System.out::println);

        /*
        output:

        one
        two
        three
        */
        }
    }

    public static class OnError {
        public static void main(String... args) {
            //onError

            Observable<String> observable = Observable.error(new RuntimeException("ooops...")); // esse Observable irá emitir apenas um erro

            observable.subscribe(System.out::println, Throwable::printStackTrace); //o segundo parâmetro é a ação que deverá ser realizada em caso de erro (um Consumer que recebe um Throwable)

            /*
            output:

            java.lang.RuntimeException: ooops...
            */
        }
    }

    public static class OnCompleted {
        public static void main(String... args) {
            //onCompleted

            Observable<String> observable = Observable.just("one", "two", "three");

            observable.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed...")); //o terceiro parâmetro é a ação que deverá ser realizada quando o Observable for completado (um objeto do tipo Action que não recebe parâmetros)

            /*
            output:

            one
            two
            three
            Completed...
            */
        }
    }

    public static class ImplementObserver {
        public static void main(String... args) {
            // outra maneira é se subscrever usando um objeto do tipo Observer;
            // desse modo você pode implementar as acões de cada evento em um único objeto

            Observable<String> observable = Observable.just("one", "two", "three");

            observable.subscribe(new Observer<String>() {

                @Override
                public void onSubscribe(Disposable d) {
                    System.out.println("Alguém se subscreveu...");
                }

                @Override
                public void onNext(String t) {
                    System.out.println(t);
                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onComplete() {
                    System.out.println("Completed...");
                }
            });

            /*
            output:

            Alguém se subscreveu...
            one
            two
            three
            Completed...
            */
        }
    }

}
