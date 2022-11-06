package com.lowleveldesign.projects.carrental.services;

import com.lowleveldesign.projects.carrental.models.Booking;
import com.lowleveldesign.projects.carrental.repository.DataStore;

public class BookingService {
    private DataStore dataStore;
    private static BookingService instance;
    private BookingService() {
        this.dataStore = DataStore.getInstance();
    }

    public static BookingService getInstance() {
        if(BookingService.instance == null) {
            synchronized (BookingService.class) {
                BookingService.instance = new BookingService();
            }
        }

        return BookingService.instance;
    }

    public Booking bookRide(String userId, String carId, String startStationId, String dropStationId, Double securityAmount) {
        //Call payment service here
        //if payment succeeds, create booking
        return this.dataStore.createNewBooking(userId, carId, startStationId, dropStationId, securityAmount);
    }
}
