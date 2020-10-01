package com.jovialcode.service.searcher.strategy;

import com.jovialcode.config.SearchConst.SEARCH_STRATEGY;
import com.jovialcode.model.vo.SearchVO;

public interface SearchStrategy {
    String search(SearchVO searchVO);
    SEARCH_STRATEGY getSearchStrategy();
}
