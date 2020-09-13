package com.jovialcode.config;

public class WebConst {

    public enum URLConst {
        NAVER("네이버", "https://www.naver.com"),
        DAUM("다음", "https://www.daum.com"),
        GOOGLE("구글", "https://www.googleapis.com/customsearch/v1");

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
