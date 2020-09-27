package com.jovialcode.service.searcher;

import com.jovialcode.service.searcher.rule.GoogleSearchRule;
import com.jovialcode.service.searcher.strategy.SearchStrategy;
import com.jovialcode.service.searcher.strategy.SeleniumStrategy;
import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;

import java.util.HashMap;
import java.util.List;

public class GoogleCrawler extends Crawler {
    private static final String URL = PropertyUtil.getProperty("GOOGLE_CRAWLER_URL");
    private SearchStrategy searchStrategy;

    public GoogleCrawler(){
        this.searchStrategy = new SeleniumStrategy();
        this.searchStrategy.setSearchRule(new GoogleSearchRule());
    }

    @Override
    public String crawling(String search) {
        String query = makeQuery(search);
        return searchStrategy.search(query);
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

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
}
