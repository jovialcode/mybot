package com.jovialcode;

import com.jovialcode.config.SearchConst;
import com.jovialcode.service.parser.DataParser;
import com.jovialcode.core.DataSearcher;
import com.jovialcode.core.WebSearcher;
import com.jovialcode.model.vo.RawDataVO;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.service.parser.DocumentParser;

public class Application {
    public static void main(String[] args){
        SearchVO target = new SearchVO();
        target.setSearchWord("마이다스아이티");

        DataSearcher dataSearcher = new WebSearcher();
        RawDataVO rawDataVO = dataSearcher.search(target, SearchConst.SEARCH_WAY.CROWLING);

        DataParser dataParser = new DocumentParser();
        dataParser.parse(rawDataVO.getInputDocument());
    }
}
