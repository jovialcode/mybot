package com.jovialcode.service.searcher.strategy;

import com.jovialcode.service.searcher.rule.SearchRule;

import java.util.List;

public interface SearchStrategy {
    String search(String query);
    void setSearchRule(SearchRule searchRule);
}
