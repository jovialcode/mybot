package com.jovialcode.core;

import com.jovialcode.config.SearchConst.SEARCH_WAY;
import com.jovialcode.model.vo.RawDataVO;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.service.searcher.Crawler;
import com.jovialcode.service.searcher.GoogleCrawler;
import org.jsoup.nodes.Document;

public class WebSearcher implements DataSearcher{
    @Override
    public RawDataVO search(SearchVO searchVO, SEARCH_WAY searchWay) {
        RawDataVO rawDataVO = new RawDataVO();
        switch (searchWay){
            case API:{
                rawDataVO.setInputString(searchOnAPI(searchVO));
                break;
            }
            case CROWLING:{
                rawDataVO.setInputString(searchOnCrawling(searchVO));
                break;
            }
        }
        return rawDataVO;
    }

    protected String searchOnAPI(SearchVO searchVO){
        return null;
    }

    protected String searchOnCrawling(SearchVO searchVO){
        Crawler crawler = new GoogleCrawler();
        return crawler.crawling(searchVO.getSearchWord());
    }
}
