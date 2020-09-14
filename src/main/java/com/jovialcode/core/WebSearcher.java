package com.jovialcode.core;

import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.service.searcher.APISearcher;
import com.jovialcode.service.searcher.GoogleAPISearcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO API호출해서 사용하는 방법과
//TODO URL 규칙 찾아서 크롤링을 사용하는 방법이 다르겠다.
//TODO 동적 데이터 크롤링도 필요하다 (Web Driver)
//TODO 멀티쓰레딩
//검색하고 평가하는건 다른 역할이겠군.
//Finder에서 find의 전략이 바뀔 수 있다고 생각한다.
public class WebSearcher implements DataSearcher{

    @Override
    public void search(SearchVO searchVO) {
        searchOnBaseURL(searchVO.getSearchWord());
    }

    /**
     * Description :
     * 여기서 각 API search하는 걸로 나눠야함.
     * */
    protected void searchOnBaseURL(String searchWord){
        APISearcher apiSearcher = new GoogleAPISearcher();
        apiSearcher.search(searchWord);
    }

    protected Document getDocument(String url){
        Document document = null;
        try{
            document = Jsoup.connect(url).get();
        }catch (IOException e){
            e.printStackTrace();
        }
        return document;
    }

    protected List<String> getATagList(Document document){
        List<String> aTagList = new ArrayList<>();

        return aTagList;
    }
}
