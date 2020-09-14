package com.jovialcode.config;

public class WebConst {

    public enum URLConst {
        NAVER("naver", "https://www.naver.com"),
        DAUM("daum", "https://www.daum.com"),
        GOOGLE("google", "https://www.googleapis.com/customsearch/v1");

        private String name;
        private String url;

        URLConst(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
