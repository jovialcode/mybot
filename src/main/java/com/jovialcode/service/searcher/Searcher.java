package com.jovialcode.service.searcher;

public interface Searcher {
    static final int HTTP_REQUEST_TIMEOUT = 3 * 600000;
    public String makeQuery(String word);
    public String search(String search);
}
