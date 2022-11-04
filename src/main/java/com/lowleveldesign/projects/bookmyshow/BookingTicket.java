package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.models.Show;

import java.util.List;

public class BookingTicket {
    private Show movieShow;
    private List<Integer> seats;
    private int totalCost;

    public BookingTicket(Show movieShow, List<Integer> seats, int totalCost) {
        this.movieShow = movieShow;
        this.seats = seats;
        this.totalCost = totalCost;
    }
}
