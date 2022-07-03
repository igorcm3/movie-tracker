package com.example.movietracker.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ApiRequest {

    @Value("${api.imdb.key}")
    private String apiKey;

    @Value("${url.imdb.api.top250}")
    private String top250URL;

    public String  getImdbTop250(){
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(top250URL.concat(apiKey) , String.class);
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseJson = restTemplate.exchange(top250URL.concat(apiKey) , HttpMethod.GET, entity, String.class);
        return responseJson.getBody();
    }
}
