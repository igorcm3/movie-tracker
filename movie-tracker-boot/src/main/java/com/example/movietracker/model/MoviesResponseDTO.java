package com.example.movietracker.model;

import java.io.Serializable;
import java.util.List;

public class MoviesResponseDTO implements Serializable {

    private List<Movie> items;
    private String errorMessage;

    public List<Movie> getItems() {
        return items;
    }

    public void setItems(List<Movie> items) {
        this.items = items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
