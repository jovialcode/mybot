package com.jovialcode.model.vo;

public class SearchRuleVO {
    String rule;
    String description;

    public SearchRuleVO(){};

    public SearchRuleVO(String rule){
        this.rule = rule;
    }

    public SearchRuleVO(String rule, String description){
        this.rule = rule;
        this.description = description;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
