package com.example.movietracker.api;


import com.example.movietracker.model.Movie;
import com.example.movietracker.model.MoviesResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiRequest {

    @Value("${api.imdb.key}")
    private String apiKey;

    @Value("${url.imdb.api.top250}")
    private String top250URL;

    @Autowired
    private ObjectMapper mapper;

    public List<Movie> getImdbTop250() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseJson = restTemplate.exchange(top250URL.concat(apiKey) , HttpMethod.GET, entity, String.class);
        MoviesResponseDTO moviesDto = mapper.readValue(responseJson.getBody(), MoviesResponseDTO.class);
        return moviesDto.getItems();
    }
}
