package com.jovialcode.service.searcher;

import com.jovialcode.config.SearchConst;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.service.searcher.strategy.SearchStrategy;
import com.jovialcode.util.PropertyUtil;
import lombok.Setter;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.jovialcode.factory.SocketFactory.socketFactory;


@Setter
public abstract class Searcher {
    static final int HTTP_REQUEST_TIMEOUT = 3 * 600000;

    static final String WEB_DRIVER_ID = PropertyUtil.getProperty("WEB_DRIVER_ID");
    static final String WEB_DRIVER_PATH = PropertyUtil.getProperty("WEB_DRIVER_PATH");

    protected SearchStrategy searchStrategy;

    protected abstract String makeQuery(String word);

    public String search(SearchVO searchVO) {
        setSearchVO(searchVO); //템플릿 메서드 패턴
        try{
            if(searchStrategy == null) throw new RuntimeException("ERROR.noSearchStrategy");
            return searchStrategy.search(searchVO);
        }catch (RuntimeException e){
            e.getMessage();
        }
        return null;
    }

    public abstract String setSearchVO(SearchVO searchVO);

    protected Document getDocument(String url){
        Connection con = Jsoup.connect(url).timeout(HTTP_REQUEST_TIMEOUT).sslSocketFactory(socketFactory());
        try{
            return con.get();
        }catch (IOException e){
            throw new RuntimeException("문서가져오기 실패", e);
        }
    }
}
