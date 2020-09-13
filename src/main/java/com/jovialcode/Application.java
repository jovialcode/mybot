package com.jovialcode;

import com.jovialcode.core.DataSearcher;
import com.jovialcode.core.WebSearcher;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.util.PropertyUtil;

public class Application {
    public static void main(String[] args){
        //1. 애플리케이션 프로퍼티 초기화
        PropertyUtil propertyUtil = new PropertyUtil();

        SearchVO target = new SearchVO();
        target.setSearchWord("Hello");

        DataSearcher dataSearcher = new WebSearcher();
        dataSearcher.search(target);
    }
}
