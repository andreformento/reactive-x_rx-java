package com.formento.reactivex.rxjava.searchpipeline.product;

import java.time.LocalDate;
import java.util.Currency;

public class Product {

    private final String title;
    private final String description;
    private final Currency price;
    private final LocalDate update;

    public Product(String title, String description, Currency price, LocalDate update) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.update = update;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Currency getPrice() {
        return price;
    }

    public LocalDate getUpdate() {
        return update;
    }
}
