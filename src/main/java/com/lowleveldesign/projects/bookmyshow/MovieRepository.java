package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    private Map<String,Movie> movies;
    private static MovieRepository instance;
    private MovieRepository() {
        this.movies = new HashMap<>();
    }

    public static MovieRepository getInstance() {
        if(MovieRepository.instance == null) {
            synchronized(MovieRepository.class) {
                MovieRepository.instance = new MovieRepository();
            }
        }

        return MovieRepository.instance;
    }

    public void addMovie(String movieId, String movieName, Integer duration) {
        this.movies.put(movieId, new Movie(movieId, movieName, duration));
    }

    public Movie getMovieById(String movieId) {
        if(!this.movies.containsKey(movieId))
            throw new EntityNotFoundException("Movie with given ID not found");

        return this.movies.get(movieId);
    }

    public List<Movie> getMoviesByName(String name) {
        List<Movie> results = new ArrayList<>();
        for(Movie movie: this.movies.values()) {
            if(movie.getMovieName().toLowerCase().equals(name.toLowerCase()))
                results.add(movie);
        }

        return results;
    }

    public List<Movie> getMoviesByDuration(Integer duration) {
        List<Movie> results = new ArrayList<>();
        for(Movie movie: this.movies.values()) {
            if(movie.getDuration().equals(duration))
                results.add(movie);
        }

        return results;
    }
}
