package com.example.movietracker.controller;


import com.example.movietracker.api.ApiRequest;
import com.example.movietracker.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiRequest api;


    @GetMapping("/top250")
    public ResponseEntity<List<Movie>> getImdbTop250() throws JsonProcessingException {
        List<Movie> top250 = this.api.getImdbTop250();
        return new ResponseEntity<List<Movie>>(top250, HttpStatus.OK);
    }
}
