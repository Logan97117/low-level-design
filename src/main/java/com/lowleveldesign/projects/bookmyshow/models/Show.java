package com.lowleveldesign.projects.bookmyshow.models;

import com.lowleveldesign.projects.bookmyshow.exceptions.SeatNotAvailableException;
import com.lowleveldesign.projects.bookmyshow.models.Movie;
import com.lowleveldesign.projects.bookmyshow.models.Screen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private Date showDateTime;
    private List<Integer> bookedSeatIds;

    public Show(String id, Movie movie, Screen screen, Date showDateTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.showDateTime = showDateTime;
        this.bookedSeatIds = new ArrayList<>();
    }

    public Screen getScreen() {
        return screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public boolean selectSeats(String userId, List<Integer> seats) {
        for(int seat: seats) {
            if(bookedSeatIds.contains(seat))
                return false;
        }

        if(this.screen.canSelectSeats(userId, seats)) {
            this.screen.selectSeats(userId, seats);
            return true;
        }

        return false;
    }

    public int bookSeats(String userId, List<Integer> seats) {
        for(int seat: seats) {
            if(bookedSeatIds.contains(seat))
                throw new SeatNotAvailableException("The seat requested is not available for booking");
        }

        if(this.screen.canBookSeats(userId, seats)) {
            this.bookedSeatIds.addAll(seats);
            return this.screen.bookSeats(seats);
        }

        throw new SeatNotAvailableException("The seat requested is not available for booking");
    }
}
