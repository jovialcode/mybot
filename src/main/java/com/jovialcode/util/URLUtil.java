package com.jovialcode.util;

import java.util.HashMap;
import java.util.stream.Collectors;

public class URLUtil {
    public static String makeQuery(HashMap<String,String> param){
        return param.entrySet()
                .stream()
                .map(e -> e.getKey().trim() + "=" + e.getValue().trim())
                .collect(Collectors.joining("&"));
    }

    public static String makeQuery(String root, HashMap<String,String> param){
        return root + "?" + makeQuery(param);
    }
}
