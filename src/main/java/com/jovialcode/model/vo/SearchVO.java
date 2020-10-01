package com.jovialcode.model.vo;

import com.jovialcode.config.SearchConst.SEARCH_STRATEGY;

import java.util.Date;
import java.util.Map;

public class SearchVO {
    private Date createTime;

    private String word;
    private String url;
    private Boolean isQuery;
    private String XPath;

    private Map<String, String> requestHeader;

    public SearchVO() {
        this.createTime = new Date();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(Boolean query) {
        isQuery = query;
    }

    public Map<String, String> getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(Map<String, String> requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getXPath() {
        return XPath;
    }

    public void setXPath(String XPath) {
        this.XPath = XPath;
    }
}
