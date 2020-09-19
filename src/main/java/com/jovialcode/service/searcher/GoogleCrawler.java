package com.jovialcode.service.searcher;

import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;

public class GoogleCrawler extends Crawler {
    private final String URL;

    public GoogleCrawler() {
        this.URL = PropertyUtil.getProperty("GOOGLE_CRAWLER_URL");
    }

    @Override
    public String makeQuery(String word) {
        HashMap<String, String> param = new HashMap<>();

        param.put("q", word);
//        param.put("source", "lang_ko");
//        param.put("ei", new Date().toString());
//        param.put("oq", word);
//        param.put("gs_lcp", "json");
//        param.put("sclient", "lang_ko");
//        param.put("ved", "lang_ko");
//        param.put("uact", "lang_ko");

        return URLUtil.makeQuery(URL, param);
    }
}
