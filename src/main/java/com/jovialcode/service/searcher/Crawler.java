package com.jovialcode.service.searcher;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public abstract class Crawler implements Searcher{
    @Override
    public String search(String word) {
        String query = makeQuery(word);
        Document document = getDocument(query);
        return document.body().toString();
    }

    protected Document getDocument(String url){
        Connection con = Jsoup.connect(url);
        try{
            return con.get();
        }catch (IOException e){
            throw new RuntimeException("문서가져오기 실패",e);
        }
    }

    protected List<String> getATagList(Document document){
        List<String> aTagList = new ArrayList<>();

        return aTagList;
    }
}
