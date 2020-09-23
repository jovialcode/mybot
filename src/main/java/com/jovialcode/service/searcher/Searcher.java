package com.jovialcode.service.searcher;

public interface Searcher<T> {
    static final int HTTP_REQUEST_TIMEOUT = 3 * 600000;
    public String makeQuery(String word);
    public T search(String search);
}
