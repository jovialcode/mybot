package com.jovialcode.core;

import com.jovialcode.config.SearchConst.SEARCH_WAY;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.service.searcher.APISearcher;
import com.jovialcode.service.searcher.Crawler;
import com.jovialcode.service.searcher.GoogleCrawler;
import com.jovialcode.service.searcher.NaverAPISearcher;

public class WebSearcher implements DataSearcher{
    @Override
    public void search(SearchVO searchVO, SEARCH_WAY searchWay) {
        switch (searchWay){
            case API:{
                searchOnAPI(searchVO);
                break;
            }
            case CROWLING:{
                searchOnCrawling(searchVO);
                break;
            }
        }
    }

    protected void searchOnAPI(SearchVO searchVO){
        APISearcher apiSearcher = new NaverAPISearcher();
        String response = apiSearcher.search(searchVO.getSearchWord());
    }

    protected void searchOnCrawling(SearchVO searchVO){
        Crawler crawler = new GoogleCrawler();
        String response = crawler.search(searchVO.getSearchWord());
    }
}
