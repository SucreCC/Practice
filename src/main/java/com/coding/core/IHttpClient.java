package com.coding.core;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * @author: dengKai
 * @date: 2022/05/23 22:47
 * @description: send http request
 */
@Data
@Accessors(chain = true)
public class IHttpClient {
    private static final String PRE_URL = "https://www.baidu.com/s?wd=";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    public ResponseEntity<String> doGet(String query) {
        String url = buildUrl(query);
        return REST_TEMPLATE.exchange(url, HttpMethod.GET, new HttpEntity<String>(null, new HttpHeaders()), String.class);
    }

    private String buildUrl(String query) {
        return PRE_URL + query;
    }
}
