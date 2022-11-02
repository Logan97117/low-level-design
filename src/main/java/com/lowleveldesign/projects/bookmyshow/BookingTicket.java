package com.lowleveldesign.projects.bookmyshow;

import java.util.List;

public class BookingTicket {
    private MovieShow movieShow;
    private List<Integer> seats;
    private int totalCost;

    public BookingTicket(MovieShow movieShow, List<Integer> seats, int totalCost) {
        this.movieShow = movieShow;
        this.seats = seats;
        this.totalCost = totalCost;
    }
}
