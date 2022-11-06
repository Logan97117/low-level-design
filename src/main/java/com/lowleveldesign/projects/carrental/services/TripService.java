package com.lowleveldesign.projects.carrental.services;

import com.lowleveldesign.projects.carrental.models.Booking;
import com.lowleveldesign.projects.carrental.repository.DataStore;

public class TripService {
    private DataStore dataStore;
    private static TripService instance;
    private TripService() {
        this.dataStore = DataStore.getInstance();
    }

    public static TripService getInstance() {
        if(TripService.instance == null) {
            synchronized(TripService.class) {
                TripService.instance = new TripService();
            }
        }

        return TripService.instance;
    }

    public void startTrip(String bookingId) {
        this.dataStore.startTrip(bookingId);
    }

    public void endTrip(String bookingId) {
        this.dataStore.endTrip(bookingId);
        Booking booking = this.dataStore.getBookingById(bookingId);

        //Use payment service to refund the security amount
        System.out.println("Actual amount paid: " + (booking.getSecurityAmountDeposited() - booking.getTotalTripAmount()));
    }

}
