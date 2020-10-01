package com.jovialcode.service.parser;

import com.jovialcode.util.URLUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StringParser implements DataParser<String, String> {
    @Override
    public String parse(String rq) {
        try(
                InputStream is = new ByteArrayInputStream(rq.getBytes());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ){
            List<String> hrefList = new ArrayList<>();
            Stream<String> lines = br.lines().filter(line -> filterRules(line));
            lines.forEach(
                    line-> URLUtil.urlMatcher(line).forEach(link ->hrefList.add(link))
            );
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
