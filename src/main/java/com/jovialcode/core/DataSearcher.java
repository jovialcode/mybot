package com.jovialcode.core;

import com.jovialcode.config.SearchConst;
import com.jovialcode.model.vo.SearchVO;

/**
 *
 * */
public interface DataSearcher{
    public void search(SearchVO searchVO, SearchConst.SEARCH_WAY searchWay);
}
