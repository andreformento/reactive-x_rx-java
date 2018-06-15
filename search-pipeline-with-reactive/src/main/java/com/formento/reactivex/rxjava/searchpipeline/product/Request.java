package com.formento.reactivex.rxjava.searchpipeline.product;

public final class Request {
    private final String query;
    private final String sort;
    private final Integer start;
    private final Integer rows;

    public Request(String query, String sort, Integer start, Integer rows) {
        this.query = query;
        this.sort = sort;
        this.start = start;
        this.rows = rows;
    }

    public String getQuery() {
        return query;
    }

    public String getSort() {
        return sort;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getRows() {
        return rows;
    }
}
