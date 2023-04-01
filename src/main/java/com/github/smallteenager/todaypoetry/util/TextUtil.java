package com.github.smallteenager.todaypoetry.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class TextUtil {

    private static final Logger log = LoggerFactory.getLogger(TextUtil.class);

    /**
     * 今日诗词
     */
    private final static String url = "https://v1.jinrishici.com/all.json";

    public static void main(String[] args){
        System.err.println(getText());
    }


    public static String getText() {

        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse closeableHttpResponse;
        try {
            closeableHttpResponse = httpClient.execute(httpGet);
            if (closeableHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String response = EntityUtils.toString(closeableHttpResponse.getEntity());
                log.info("url:{},response:{}", url, response);
                if (!(response == null || response.length() == 0)) {
                    JSONObject jsonObject = JSON.parseObject(response);
                    result = jsonObject.getString("content");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
