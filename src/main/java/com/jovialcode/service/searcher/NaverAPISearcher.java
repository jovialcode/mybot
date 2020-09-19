package com.jovialcode.service.searcher;

import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;

import java.util.HashMap;
import java.util.Map;

public class NaverAPISearcher extends APISearcher {
    private final String URL;
    private final String CLIENT_ID;
    private final String CLIENT_SECRET;

    public NaverAPISearcher() {
        this.URL = PropertyUtil.getProperty("NAVER_URL");
        this.CLIENT_ID = PropertyUtil.getProperty("NAVER_CLIENT_ID");
        this.CLIENT_SECRET = PropertyUtil.getProperty("NAVER_CLIENT_SECRET");
    }

    @Override
    public String makeQuery(String word) {
        HashMap<String, String> param = new HashMap<>();

        param.put("query", word);

        return URLUtil.makeQuery(URL, param);
    }

    @Override
    public Map<String, String> makeRequestHeader() {
        Map<String, String> requestHeaders = new HashMap<>();

        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

        return requestHeaders;
    }
}
