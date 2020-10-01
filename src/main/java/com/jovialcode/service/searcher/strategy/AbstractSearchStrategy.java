package com.jovialcode.service.searcher.strategy;

import com.jovialcode.service.searcher.rule.SearchRule;

public abstract class AbstractSearchStrategy implements SearchStrategy{
    private SearchRule searchRule;

    public SearchRule getSearchRule() {
        return searchRule;
    }

    public void setSearchRule(SearchRule searchRule) {
        this.searchRule = searchRule;
    }
}
