package com.jovialcode.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class SearchVO {
    private Date createTime;
    private String searchWord;

    public SearchVO() {
        this.createTime = new Date();
    }
}
