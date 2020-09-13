package com.jovialcode.service.searcher;

import com.jovialcode.config.WebConst;
import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;

/**
 * APISearch와 동일한 interface를 구현한다.
* */
@Getter
@Setter
public class GoogleAPISearcher extends APISearcher {
    private Integer queryCount;
    private String searchEngineID;

    public GoogleAPISearcher() {
        super(
                WebConst.URLConst.GOOGLE.getUrl(),
                PropertyUtil.getProperty("googleAPI_KEY")
        );
        searchEngineID = PropertyUtil.getProperty("googleSEARCH_ENGINE_ID");
    }

    @Override
    public Object search(String word) {
        String query = makeQuery(word);

        try{
            super.getConnection(query);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String makeQuery(String word) {
        HashMap<String, String> param = new HashMap<>();

        param.put("key", getApiKey());
        param.put("cx", searchEngineID);
        param.put("q", word);
        param.put("alt", "json");
        param.put("lang", "lang_ko");

        return URLUtil.makeQuery(getBasUrl(), param);
    }
}
