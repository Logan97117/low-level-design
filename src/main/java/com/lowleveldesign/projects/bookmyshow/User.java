package com.lowleveldesign.projects.bookmyshow;

import java.util.List;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private BookingHistory bookingHistory;

    public User(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookingHistory = new BookingHistory();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BookingTicket> showBookingHistory() {
        return this.bookingHistory.getBookingHistory();
    }

    public void addBookingHistory(BookingTicket ticket) {
        this.bookingHistory.addBookingHistory(ticket);
    }
}
