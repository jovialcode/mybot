package com.jovialcode.service.parser;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser implements DataParser<String, String> {
    @Override
    public String parse(String rq) {
        try(
                InputStream is = new ByteArrayInputStream(rq.getBytes());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ){
            Stream<String> lines = br.lines();
            List<String> hrefList = lines
                    .filter(line -> filterRules(line))
                    .map(line -> getUrlPattern(line))
                    .collect(Collectors.toList());
            return hrefList.get(0);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

//    private String filterHref(String str){
//
//    }
}
