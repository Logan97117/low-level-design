package com.lowleveldesign.projects.bookmyshow;

import java.util.Map;

public class MovieShow {
    private Movie movie;
    private Integer startTime;
    private Integer endTime;
    private SeatingArrangement seatingArrangement;

    public MovieShow(Movie movie, Integer startTime, int numSeats, Map<Integer,Integer> rowPriceMap) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = this.startTime + this.movie.getDuration();
        this.seatingArrangement = new SeatingArrangement(numSeats, rowPriceMap);
    }

    public Movie getMovie() {
        return movie;
    }

    public SeatingArrangement getSeatingArrangement() {
        return seatingArrangement;
    }
}
