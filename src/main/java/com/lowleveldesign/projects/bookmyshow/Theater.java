package com.lowleveldesign.projects.bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Theater {
    private String id;
    private int numSeats;
    private List<MovieShow> movieShows;
    private Map<Integer,Integer> defaultPriceMap;
    public Theater(String id, int numSeats, Map<Integer,Integer> defaultPriceMap) {
        this.id = id;
        this.movieShows = new ArrayList<>();
        this.numSeats = numSeats;
        this.defaultPriceMap = defaultPriceMap;
    }

    public String getId() {
        return id;
    }

    public void addMovieShow(Movie movie, Integer startTime, Map<Integer,Integer> rowPriceMap) {
        this.movieShows.add(new MovieShow(movie, startTime, this.numSeats, rowPriceMap));
    }

    public void addMovieShow(Movie movie, Integer startTime) {
        this.movieShows.add(new MovieShow(movie, startTime, this.numSeats, this.defaultPriceMap));
    }

    public List<MovieShow> getMovieShowsByMovieId(String id) {
        List<MovieShow> result = new ArrayList<>();
        for(MovieShow movieShow: this.movieShows) {
            if(movieShow.getMovie().getId().equals(id))
                result.add(movieShow);
        }

        return result;
    }
}
