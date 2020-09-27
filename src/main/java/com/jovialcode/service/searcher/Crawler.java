package com.jovialcode.service.searcher;

import com.jovialcode.util.PropertyUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.jovialcode.factory.SocketFactory.socketFactory;

public abstract class Crawler{
    static final int HTTP_REQUEST_TIMEOUT = 3 * 600000;

    static final String WEB_DRIVER_ID = PropertyUtil.getProperty("WEB_DRIVER_ID");
    static final String WEB_DRIVER_PATH = PropertyUtil.getProperty("WEB_DRIVER_PATH");

    protected Document getDocument(String url){
        Connection con = Jsoup.connect(url).timeout(HTTP_REQUEST_TIMEOUT).sslSocketFactory(socketFactory());
        try{
            return con.get();
        }catch (IOException e){
            throw new RuntimeException("문서가져오기 실패", e);
        }
    }

    protected abstract String makeQuery(String word);

    public abstract String crawling(String word);
}
