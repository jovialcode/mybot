package com.jovialcode.core;

import com.jovialcode.config.SearchConst;
import com.jovialcode.service.searcher.NaverSearcher;
import com.jovialcode.service.searcher.Searcher;
import com.jovialcode.service.searcher.GoogleSearcher;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WebSearcher{
    private String searchTarget;

    public Searcher getSearcher(SearchConst.SEARCH_TARGET searchTarget){
        switch (searchTarget){
            case GOOGLE:{
                return new GoogleSearcher();
            }
            case NAVER:{
                return new NaverSearcher();
            }
            default:{
                return null;
            }
        }
    }
}
