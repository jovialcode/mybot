package com.jovialcode;

import com.jovialcode.config.SearchConst;
import com.jovialcode.core.WebSearcher;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.service.parser.DataParser;
import com.jovialcode.service.parser.StringParser;
import com.jovialcode.service.searcher.Searcher;
import com.jovialcode.service.searcher.strategy.SeleniumStrategy;

public class Application {
    public static void main(String[] args){
        SearchVO searchVO = new SearchVO();
        searchVO.setWord("마이다스아이티");

        WebSearcher webSearcher = new WebSearcher();
        Searcher searcher = webSearcher.getSearcher(SearchConst.SEARCH_TARGET.NAVER);
        searcher.setSearchStrategy(new SeleniumStrategy());

        String rs = searcher.search(searchVO);
        DataParser dataParser = new StringParser();
        System.out.println(dataParser.parse(rs));
    }

    public void initSearcher(){

    }
}
