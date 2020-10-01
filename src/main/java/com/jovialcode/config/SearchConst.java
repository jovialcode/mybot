package com.jovialcode.config;

public class SearchConst {
    public enum SEARCH_TARGET{
        GOOGLE("구글", "2020-09-20 추가"),
        NAVER("네이버", "2020-10-01 추가"),
        DAUM("다음", "2020-09-20 추가");

        private final String name;
        private final String description;

        SEARCH_TARGET(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    public enum SEARCH_STRATEGY{
        CRAWLING("CRAWLING", "단순 서버렌더링"),
        API("API", "검색 엔진에서 제공하는 API사용"),
        SELENIUM("SELENIUM", "클라이언트 렌더링 까지");

        private final String name;
        private final String description;

        SEARCH_STRATEGY(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

//    public enum NAVER_SEARCH_TYPE{
//        블로그("blog"),
//        뉴스("news"),
//        웹문서("webkr"),
//        지식iN("kin"),
//        카페글("cafearticle"),
//        영화("movie"),
//        책("book");
//
//        private final String name;
//
//        NAVER_SEARCH_TYPE(String name) {
//            this.name = name;
//        }
//    }
}
