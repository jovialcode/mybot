package com.jovialcode.service.searcher.rule;

import com.jovialcode.model.vo.SearchRuleVO;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchRule implements SearchRule{
    List<SearchRuleVO> rules;
    public GoogleSearchRule(){
        this.rules = new ArrayList<>();
        rules.add(new SearchRuleVO("/html/body//a/@href", "a 태그에서 href 추출"));
    }

    @Override
    public List<SearchRuleVO> getRules() {
        return this.rules;
    }
}
