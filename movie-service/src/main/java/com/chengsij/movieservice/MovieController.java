package com.chengsij.movieservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    private static List<Movie> movieList = new ArrayList<>();

    static {
        movieList.add(new Movie(1, "Followship of the Ring", "fellowship of the ring"));
        movieList.add(new Movie(2, "Two Towers", "Defeat Sarauman"));
        movieList.add(new Movie(3, "Return of the Kind", "Destroy the ring"));
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies(){
        return ResponseEntity.ok(movieList);
    }
}
