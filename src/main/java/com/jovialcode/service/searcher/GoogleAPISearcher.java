package com.jovialcode.service.searcher;

import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * APISearch와 동일한 interface를 구현한다.
* */
@Getter
@Setter
public class GoogleAPISearcher extends APISearcher {
    private final String URL;
    private final String APIkey;
    private final String searchEngineID;

    public GoogleAPISearcher() {
        this.APIkey = PropertyUtil.getProperty("GOOGLE_API_KEY");
        this.URL = PropertyUtil.getProperty("GOOGLE_API_URL");
        this.searchEngineID = PropertyUtil.getProperty("GOOGLE_SEARCH_ENGINE_ID");
    }

    @Override
    public String makeQuery(String word) {
        HashMap<String, String> param = new HashMap<>();

        param.put("key", APIkey);
        param.put("cx", searchEngineID);
        param.put("q", word);
        param.put("alt", "json");
        param.put("lang", "lang_ko");

        return URLUtil.makeQuery(URL, param);
    }

    @Override
    public Map<String, String> makeRequestHeader() {
        return null;
    }
}
