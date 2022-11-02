package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.enums.SeatStatus;

import java.util.List;
import java.util.Map;

public class SeatingArrangement {
    private int numSeats;
    private Seat seats[];
    public SeatingArrangement(int numSeats, Map<Integer,Integer> rowPriceMap) {
        this.numSeats = numSeats;
        this.seats = new Seat[this.numSeats];
        this.init(rowPriceMap);
    }

    private void init(Map<Integer,Integer> seatPriceMap) {
        for(int i = 0; i<this.numSeats;i++) {
            this.seats[i] = new Seat(seatPriceMap.get(i));
        }
    }

    public void lockSeats(List<Integer> seats) {
        for(int seat: seats) {
            this.seats[seat].setSeatStatus(SeatStatus.LOCKED);
        }
    }

    public int bookSeatsAndReturnCost(User user, List<Integer> seats) {
        int totalCost = 0;
        for(int seat: seats) {
            this.seats[seat].setSeatStatus(SeatStatus.NOT_AVAILABLE);
            this.seats[seat].setUserBooked(user);
            totalCost += this.seats[seat].getCost();
        }

        return totalCost;
    }
}
