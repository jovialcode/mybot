package com.jovialcode.service.searcher.strategy;

import com.jovialcode.config.SearchConst.SEARCH_STRATEGY;
import com.jovialcode.model.vo.SearchVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIStrategy extends AbstractSearchStrategy {

    @Override
    public String search(SearchVO searchVO) {
        //Map<String, String> requestHeaders = makeRequestHeader();

        HttpURLConnection con = getConnection(searchVO.getUrl());

        try {
            con.setRequestMethod("GET");
//            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
//                con.setRequestProperty(header.getKey(), header.getValue());
//            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return getBody(con.getInputStream());
            } else { // 에러 발생
                return getBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection getConnection(String apiUrl) {
        try {
            java.net.URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private String getBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

    //public abstract Map<String, String> makeRequestHeader();


    @Override
    public SEARCH_STRATEGY getSearchStrategy() {
        return SEARCH_STRATEGY.API;
    }
}
