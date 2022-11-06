package com.lowleveldesign.projects.carrental.models;

import com.lowleveldesign.projects.carrental.enums.TripStatus;

import java.util.UUID;

public class Booking {
    private UUID id;
    private Car car;
    private User user;
    private Station startStation;
    private Station dropStation;
    private Double securityAmountDeposited;
    private Long tripStartTime;
    private Long tripEndTime;
    private TripStatus tripStatus;
    private Double totalTripAmount;

    public Booking(Car car, User user, Station startStation, Station dropStation, Double securityAmountDeposited) {
        this.car = car;
        this.user = user;
        this.startStation = startStation;
        this.dropStation = dropStation;
        this.securityAmountDeposited = securityAmountDeposited;
        this.tripStatus = TripStatus.NOT_STARTED;
        this.id = new UUID(0,9);
    }

    public String getId() {
        return id.toString();
    }

    public Car getCar() {
        return car;
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getDropStation() {
        return dropStation;
    }

    public void setTripStartTime(Long tripStartTime) {
        this.tripStatus = TripStatus.IN_PROGRESS;
        this.tripStartTime = tripStartTime;
    }

    public void setTripEndTime(Long tripEndTime) {
        this.tripEndTime = tripEndTime;
        this.tripStatus = TripStatus.FINISHED;
        this.totalTripAmount = ((double)((this.tripEndTime - this.tripStartTime)/1000.0*60*60))*this.car.getPricePerHour();
    }

    public Double getSecurityAmountDeposited() {
        return securityAmountDeposited;
    }

    public Double getTotalTripAmount() {
        return totalTripAmount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", car=" + car +
                ", user=" + user +
                ", startStation=" + startStation +
                ", dropStation=" + dropStation +
                ", securityAmountDeposited=" + securityAmountDeposited +
                ", tripStartTime=" + tripStartTime +
                ", tripEndTime=" + tripEndTime +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
