package com.lowleveldesign.projects.bookmyshow.models;

import com.lowleveldesign.projects.bookmyshow.enums.PricePlan;
import com.lowleveldesign.projects.bookmyshow.enums.SeatStatus;
import com.lowleveldesign.projects.bookmyshow.factories.PricePlanFactory;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String id;
    private List<Seat> seats;
    private Theater theater;
    public Screen(String id, int numSeats, PricePlan pricePlan, Theater theater) {
        this.id = id;
        this.seats = new ArrayList<>();
        this.initSeats(numSeats);
        this.assignPrices(pricePlan);
        this.theater = theater;
    }

    private void initSeats(int numSeats) {
        for(int i = 0; i<numSeats; i++)
            this.seats.add(new Seat());
    }

    public void assignPrices(PricePlan pricePlan) {
        PricePlanFactory.initialiseSeatsAsPerPricePlan(this.seats, pricePlan);
    }

    public Theater getTheater() {
        return theater;
    }

    public boolean canSelectSeats(String userId, List<Integer> seats) {
        for(int seat: seats) {
            if(!this.seats.get(seat).canSelectSeat(userId))
                return false;
        }

        return true;
    }

    public void selectSeats(String userId, List<Integer> seats) {
        for(int seat: seats)
            this.seats.get(seat).selectSeat(userId);
    }

    public boolean canBookSeats(String userId, List<Integer> seats) {
        for(int seat: seats) {
            if(!this.seats.get(seat).canBookSeat(userId))
                return false;
        }

        return true;
    }

    public int bookSeats(List<Integer> seats) {
        int cost = 0;
        for(int seat: seats) {
            cost += this.seats.get(seat).bookSeat();
        }

        return cost;
    }
}
