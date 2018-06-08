package com.formento.reactivex.reactivexexamples;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

public class ConcatWith {

    static class Request {
        private final String query;
        private final String sort;

        Request(final String query, final String sort) {
            this.query = query;
            this.sort = sort;
        }
    }

    public static void main(String... args) {
        Mono<Request> request = Mono.just(new Request("caneca", "preco"));
        findByPreco(request)
                .concatWith(findByRelevancia(request))
                .switchIfEmpty(whatever(request))
                .subscribe(System.out::println);

    }

    private static Publisher<? extends String> whatever(final Mono<Request> request) {
        return request
                .map(s -> "query loka " + s);
    }

    private static Publisher<? extends String> findByRelevancia(final Mono<Request> request) {
        return request
                .filter(r -> r.sort.equals("relevancia"))
                .map(r -> "relevancia: " + r.query.toUpperCase());
    }

    private static Mono<String> findByPreco(final Mono<Request> request) {
        return request
                .filter(r -> r.sort.equals("preco"))
                .map(r -> r.query.toUpperCase());
    }

}
