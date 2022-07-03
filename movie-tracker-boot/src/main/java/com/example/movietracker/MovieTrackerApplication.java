package com.example.movietracker;

import com.example.movietracker.api.ApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTrackerApplication.class, args);
	}

}
