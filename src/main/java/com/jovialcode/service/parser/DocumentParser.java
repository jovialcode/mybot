package com.jovialcode.service.parser;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DocumentParser implements DataParser<Document, String> {
    public String parse(Document document) {
        Elements aTagList = getTagElements(document, "a");
        Elements tagHasHrefAttribute = getElementsByAttribute(document, "href");
        List<String> hrefList = getAttributeList(aTagList, "href");
        List<String> filteredHrefList = filterHref(hrefList);
        return null;
    }

    private List<String> filterHref(List<String> hrefList){
        return hrefList.stream()
                .map(s -> s.trim())
                .filter(s -> filterRules(s))
                .collect(Collectors.toList());
    }

    private Boolean filterRules(String href){
        Predicate<String> startHttps = e -> e.startsWith("https://");
        Predicate<String> startWWW = e -> e.startsWith("www");
        return startHttps.test(href) || startWWW.test(href);
    }

    private Elements getTagElements(Document document, String tagName){
        return document.select(tagName);
    }

    private Elements getElementsByAttribute(Document document, String attributeName){
        return document.getElementsByAttribute(attributeName);
    }

    private List<String> getAttributeList(Elements elements, String attributeName){
        return elements.eachAttr(attributeName);
    }
}
