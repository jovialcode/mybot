package com.jovialcode.service.searcher;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.jovialcode.factory.SocketFactory.socketFactory;

public abstract class Crawler implements Searcher{

    protected Document getDocument(String url){
        Connection con = Jsoup.connect(url).timeout(HTTP_REQUEST_TIMEOUT).sslSocketFactory(socketFactory());
        try{
            return con.get();
        }catch (IOException e){
            throw new RuntimeException("문서가져오기 실패", e);
        }
    }
}
