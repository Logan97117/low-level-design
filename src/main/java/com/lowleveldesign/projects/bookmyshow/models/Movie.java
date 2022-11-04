package com.lowleveldesign.projects.bookmyshow.models;

public class Movie {
    private String id;
    private String movieName;
    private Integer duration;

    public Movie(String id, String movieName, Integer duration) {
        this.id = id;
        this.movieName = movieName;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public Integer getDuration() {
        return duration;
    }
}
