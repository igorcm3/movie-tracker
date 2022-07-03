package com.example.movietracker.controller;


import com.example.movietracker.api.ApiRequest;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MovieTrackerController {

    @Autowired
    private ApiRequest api;


    @GetMapping("/top250")
    public ResponseEntity<String> getImdbTop250(){
        String top250 = this.api.getImdbTop250();
        return new ResponseEntity<String>(top250, HttpStatus.OK);
    }




}
