package com.jovialcode.core;

import com.jovialcode.config.SearchConst;
import com.jovialcode.model.vo.RawDataVO;
import com.jovialcode.model.vo.SearchVO;

/**
 *
 * */
public interface DataSearcher{
    public RawDataVO search(SearchVO searchVO, SearchConst.SEARCH_WAY searchWay);
}
