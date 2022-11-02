package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.enums.SeatStatus;

public class Seat {
    private SeatStatus seatStatus;
    private User userBooked;
    private Integer cost;
    public Seat(Integer cost) {
        this.cost = cost;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public User getUserBooked() {
        return userBooked;
    }

    public void setUserBooked(User userBooked) {
        this.userBooked = userBooked;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
