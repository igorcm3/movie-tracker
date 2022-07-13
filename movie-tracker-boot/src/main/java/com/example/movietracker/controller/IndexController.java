package com.example.movietracker.controller;

import com.example.movietracker.api.ApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class IndexController {

    @Autowired
    private ApiRequest apiRequest;
    @GetMapping("/index")
    public String getInex(Model model){
        try {
            model.addAttribute("movies", this.apiRequest.getImdbTop250());
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }
}
