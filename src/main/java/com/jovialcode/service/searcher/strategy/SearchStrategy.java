package com.jovialcode.service.searcher.strategy;

public interface SearchStrategy<T> {
    public T search(String query);
}
