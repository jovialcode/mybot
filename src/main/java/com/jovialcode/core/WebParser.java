package com.jovialcode.core;

import com.jovialcode.model.vo.DataVO;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

public class WebParser implements DataParser<DataVO> {

    @Override
    public DataVO parse() {
        DataVO dataVO = new DataVO();

        return dataVO;
    }

    protected List<String> getATagList(Document document){
        List<String> aTagList = new ArrayList<>();

        return aTagList;
    }
}
