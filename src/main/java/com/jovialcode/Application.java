package com.jovialcode;

import com.jovialcode.core.DataSearcher;
import com.jovialcode.core.WebSearcher;
import com.jovialcode.model.vo.SearchVO;

public class Application {
    public static void main(String[] args){
        SearchVO target = new SearchVO();
        target.setSearchWord("Hello");

        DataSearcher dataSearcher = new WebSearcher();
        dataSearcher.search(target);
    }
}
