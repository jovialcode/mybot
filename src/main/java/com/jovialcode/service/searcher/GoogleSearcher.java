package com.jovialcode.service.searcher;

import com.jovialcode.config.SearchConst;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.util.PropertyUtil;
import com.jovialcode.util.URLUtil;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
public class GoogleSearcher extends Searcher {
    private final String URL = PropertyUtil.getProperty("GOOGLE_SEARCH_URL");

    @Override
    public String setSearchVO(SearchVO searchVO) {
        searchVO.setUrl(URL);
        searchVO.setIsQuery(true);
        if (searchStrategy.getSearchStrategy().equals(SearchConst.SEARCH_STRATEGY.SELENIUM)){
            searchVO.setXPath(PropertyUtil.getProperty("GOOGLE_SEARCH_XPATH"));
            searchVO.setIsQuery(false);
        }
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
