package com.chengsij.recommendationservice;
import java.util.ArrayList;
import java.util.List;

public class MovieDB {

    public static List<Movie> movieList = new ArrayList<>();

    static {
        movieList.add(new Movie(1, "Followship of the Ring", "fellowship of the ring"));
        movieList.add(new Movie(2, "Two Towers", "Defeat Sarauman"));
        movieList.add(new Movie(3, "Return of the Kind", "Destroy the ring"));
    }

}
