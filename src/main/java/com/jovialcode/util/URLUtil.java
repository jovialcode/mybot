package com.jovialcode.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * URLUtil
 * 패턴 : 정적 클래스
 * */
public class URLUtil {
    public static String encodeURL(String word){
        try {
            word = URLEncoder.encode(word, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
        return word;
    }

    public static String decodeURL(String word){
        try {
            word = URLDecoder.decode(word, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 디코딩 실패",e);
        }
        return word;
    }

    public static String makeQuery(HashMap<String,String> param){
        return param.entrySet()
                .stream()
                .map(e -> e.getKey().trim() + "=" + encodeURL(e.getValue().trim()))
                .collect(Collectors.joining("&"));
    }

    public static String makeQuery(String root, HashMap<String,String> param){
        return root.trim() + "?" + makeQuery(param);
    }
}
