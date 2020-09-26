package com.jovialcode.service.searcher;

import com.jovialcode.util.PropertyUtil;

public interface Searcher<T> {
    static final int HTTP_REQUEST_TIMEOUT = 3 * 600000;

    static final String WEB_DRIVER_ID = PropertyUtil.getProperty("WEB_DRIVER_ID");
    static final String WEB_DRIVER_PATH = PropertyUtil.getProperty("WEB_DRIVER_PATH");

    public String makeQuery(String word);
    public T search(String search);
}
