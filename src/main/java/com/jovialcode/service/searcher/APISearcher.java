package com.jovialcode.service.searcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public abstract class APISearcher{
    private String basUrl;
    private String apiKey;
    private HashMap<String,String> appendix;

    public APISearcher(String basUrl, String apiKey) {
        this.basUrl = basUrl;
        this.apiKey = apiKey;
    }

    protected String getConnection(String query) throws IOException {
        URL url = new URL(query);
        String output = null;
        HttpURLConnection conn = null;
        BufferedReader br = null;
        try{
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            while ((output = br.readLine()) != null) {

                if(output.contains("\"link\": \"")){
                    String link= output.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
            br.close();
        }
        return output;
    }

    public abstract Object search(String word);

    public abstract String makeQuery(String word);

    public String getBasUrl() { return basUrl; }

    public String getApiKey() {
        return apiKey;
    }
}
