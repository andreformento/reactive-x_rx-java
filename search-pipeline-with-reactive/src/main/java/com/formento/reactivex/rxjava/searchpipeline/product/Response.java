package com.formento.reactivex.rxjava.searchpipeline.product;

import java.util.List;

public class Response {

    private final List<Product> products;
    private final Integer hits;

    public Response(List<Product> products, Integer hits) {
        this.products = products;
        this.hits = hits;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Integer getHits() {
        return hits;
    }
}
