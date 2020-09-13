package com.jovialcode.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

@Setter
@Getter
public class WebSearchVO extends SearchVO{
    private String rootUrl;
    private String currentUrl;

    private HashMap<String, Boolean> visitUrl;

    public WebSearchVO() {
        super();
    }
}
