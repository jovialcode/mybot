package com.jovialcode.service.parser;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  T : input Type
 *  R : return Type
 * */
public interface DataParser<T, R> {
    Pattern urlPattern = Pattern.compile("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");

    R parse(T t);

    default Boolean filterRules(String href){
        Predicate<String> startHttps = e -> e.contains("https://");
        Predicate<String> startWWW = e -> e.contains("www");
        return startHttps.test(href) || startWWW.test(href);
    }

    default String getUrlPattern(String str){
        Matcher matcher = urlPattern.matcher(str);
        return matcher.matches() ? matcher.group(0) : null;
    }
}
