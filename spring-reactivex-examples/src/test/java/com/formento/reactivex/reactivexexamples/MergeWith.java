package com.formento.reactivex.reactivexexamples;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MergeWith {

    static class Request {
        private final String query;
        private final String sort;

        Request(final String query, final String sort) {
            this.query = query;
            this.sort = sort;
        }
    }

    public static void main(String... args) throws InterruptedException {
        Mono<Request> request = Mono.just(new Request("caneca", "preco"));

        System.out.println("Thread principal: " + Thread.currentThread().getId());

        findByPreco(request)
                .mergeWith(findByRelevancia(request))
                .switchIfEmpty(whatever(request))
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }

    private static Publisher<? extends String> whatever(final Mono<Request> request) {
        return request
                .map(s -> {
                    System.out.println("Thread do fallback: " + Thread.currentThread().getId());
                    return "query loka " + s;
                })
                .subscribeOn(Schedulers.elastic());
    }

    private static Publisher<? extends String> findByRelevancia(final Mono<Request> request) {
        return request
                .filter(r -> {
                    System.out.println("Thread do filtro de relevancia: " + Thread.currentThread().getId());
                    return r.sort.equals("relevancia");
                })
                .map(r -> {
                    System.out.println("Thread do filtro de relevancia: " + Thread.currentThread().getId());
                    return "relevancia: " + r.query.toUpperCase();
                })
                .subscribeOn(Schedulers.elastic());
    }

    private static Mono<String> findByPreco(final Mono<Request> request) {
        return request
                .filter(r -> {
                    System.out.println("Thread do filtro de preco: " + Thread.currentThread().getId());
                    return r.sort.equals("preco");
                })
                .map(r -> {
                    System.out.println("Thread do filtro de preco: " + Thread.currentThread().getId());
                    return "preco: " + r.query.toUpperCase();
                })
                .subscribeOn(Schedulers.elastic());
    }

}
