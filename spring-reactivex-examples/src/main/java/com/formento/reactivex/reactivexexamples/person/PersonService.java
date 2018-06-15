package com.formento.reactivex.reactivexexamples.person;

import java.time.Duration;
import java.util.UUID;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(final PersonRepository repository) {
        this.repository = repository;
    }

    public Mono<Person> getPersonById(final UUID id) {
        return repository.getPersonById(id);
    }

    public Mono<Person> search(final Mono<Person> person) {
        return null;


//        return person.map(p -> {
//            if (p.getSort() == "price") {
//                return repository.sortByPrice(p);
//            } else {
//                return repository.sortByRelevance(p);
//            }
//        });
    }

    public static void main(String...args) throws InterruptedException {
//        Mono<Person> person = Mono.just(new Person("bla", 1, "timeout"));

//        Mono<String> person = Mono.just("timeout");
//
//        System.out.println("Eu estou processando na thread " + Thread.currentThread().getId());
//
//        person.filter(p -> p.equals("preco"))
//                .map(p -> "Essa e uma query por preco")
//                .concatWith(person.filter(p -> p.equals("relevancia"))
//                        .map(p -> "Essa e uma query por relevancia"))
//                .concatWith(person.filter(p -> p.equals("timeout"))
//                        .map(p -> {
//                            try {
//                                Thread.sleep(3000);
//                                return "";
//                            } catch (InterruptedException e) {
//                                throw  new RuntimeException(e);
//                            }
//                        })
//                        .timeout(Duration.ofMillis(1000), Mono.just("ih, deu timeout"))
//
////        ).switchIfEmpty(Mono.just("eu sou um fallback"))
//        ).subscribeOn(Schedulers.elastic())
//                .subscribe(value -> {
//                    System.out.println("Eu estou processando na thread " + Thread.currentThread().getId());
//                    System.out.println(value);
//                });
//
//        Thread.sleep(2000);

        Mono<String> first = Mono.just("first").subscribeOn(Schedulers.elastic());
        first.subscribe(value -> {
                    System.out.println("Eu estou processando na thread " + Thread.currentThread().getId());
                    System.out.println(value);
                });

        Mono<String> second = Mono.just("second").subscribeOn(Schedulers.elastic());
        second.subscribe(value -> {
            System.out.println("Eu estou processando na thread " + Thread.currentThread().getId());
            System.out.println(value);
        });

        Mono<String> third = Mono.just("third").subscribeOn(Schedulers.elastic());
        third.subscribe(value -> {
            System.out.println("Eu estou processando na thread " + Thread.currentThread().getId());
            System.out.println(value);
        });

        Mono.zip(first, second, third)
            .subscribe(value -> {
                System.out.println("Merge do baguio, Eu estou processando na thread " + Thread.currentThread().getId());
                System.out.println(value);
            });

        Thread.sleep(2000);

    }
}
