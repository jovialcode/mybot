package com.jovialcode.service.searcher;

import com.jovialcode.service.searcher.strategy.SearchStrategy;
import com.jovialcode.service.searcher.strategy.SeleniumStrategy;
import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;
import org.openqa.selenium.WebElement;

import javax.swing.text.Document;
import java.util.HashMap;

public class GoogleCrawler extends Crawler {
    private static final String URL = PropertyUtil.getProperty("GOOGLE_CRAWLER_URL");;

    @Override
    public Document search(String search) {
        SearchStrategy<WebElement> searchStrategy = new SeleniumStrategy();
        String query = makeQuery(search);
        WebElement webElement = searchStrategy.search(query);
        String value = webElement.toString();
        return null;
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
