package com.jovialcode.service.parser;

import com.jovialcode.util.URLUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringParserTest{
    @Before
    public void search(){

    }

    @Test
    public void URL_파싱이_잘되어야하는데(){
        List<String> targetUrlList = new ArrayList<>();
        targetUrlList.add(".gnb_favorite_lst .gnb_add a span.ic_add{display:block;width:36px;height:36px;margin:0 auto 4px;background-image: url(https://ssl.pstatic.net/static/common/gnb/one/sp_gnb_4b16e6.png);background-position: 0px 0px;background-repeat: no-repeat;width: 36px;height: 36px;vertical-align: top;}");
        targetUrlList.add("https://goodidea.tistory.com/qr/aaa/ddd?ace=123");
        targetUrlList.add("<a href=\"https://adcr.naver.com/adcr?x=WxOfQA1D3adQEmk8UiqyYf///w==kCZNmAYOH8sDv6e6SeEjNdimzDMNOYdHsMahO8nNU/LIzL+W549s1vvi5o8As7msewW3/tk24FuDeEVkfcdmejQB3iUgVKBiQOX/BnQnwjgBzO8Zd/jXCkKRvzY7BBjJYcY9+mhS1qXzekRiJe03VgE/U+5mZu7+h299jeNJ1ShuLhux2qrfIbZfvkn8lDw1MlSjZoBArZbJvqQ+WYKaWsK0fmf5nIKplt3HhhUr6iqPBf4tU76N2vuCf8uwFym7wr8YCcKKUsGzt2DtZLRSjsqxJydHJvy6UBjURrrceKv5fI/nXwCcta1PBMleSsNa943UvPbWsUdYM0IZSv/TP1BHZSyPnmzen3WVSi/1BlzP07Aek2PT0tOfluWlLzBrznMGAR/N3N4oHAT0Hyv9ji7v9N3wKYIxUTz1hF6NaG2idRWhtvRgbqpc/uUk84Nc0OFrlyrW+RMAwBNs8sAU/436/deqI0Qyun8ahh0maTlcsLHp3ZE3Gh6aQsJREODZiGHoQ7asLIRaViWWYSZN5SeGMaRB7rRuD5aUXV7HPLXUPPrIPYmsUNichbuhQERSECsN3d2gjKeWILQQzvFdf+1+d5tO0flthOqaJo+ejtEiKKnw8AjrLOFuygO7VtzQnCkLUcYOeAl3jc1+FIBoKNtL/5uOpHE9Qzr/6qYMKRrY=&amp;p=1\" class=\"lnk_url\" target=\"_blank\" onclick=\"return goOtherCR(this, 'a=pwl_nop.url&amp;r=1&amp;i=nad-a001-01-000000075758511&amp;d='+urlencode('http://www.midashri.com')+'&amp;u='+urlencode(this.href));\">www.midashri.com</a>");

        List<String> rs = new ArrayList<>();
        targetUrlList.forEach(
                line-> URLUtil.urlMatcher(line).forEach(link ->rs.add(link))
        );
        Assert.assertEquals(5, rs.size());
    }

    @Test
    public void 연산자_확인(){
        Integer a = 10;
        int b = 11;

        Assert.assertEquals(21, a + b);
    }

    @Test
    public void 연산자_double(){
        double d1 = 3;
        double d2 = 0.01;
        System.out.println(d1 + d2);
    }

    @Test
    public void 맵_테스트(){
        Map<String, List<String>> mapList = new HashMap<>();
        mapList.put("레옹", new ArrayList<>());
        mapList.get("레옹").add("레옹아들");
    }
}
