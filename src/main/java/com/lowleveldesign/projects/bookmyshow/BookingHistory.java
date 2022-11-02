package com.lowleveldesign.projects.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
    private List<BookingTicket> tickets;
    public BookingHistory() {
        this.tickets = new ArrayList<>();
    }

    public void addBookingHistory(BookingTicket ticket) {
        this.tickets.add(ticket);
    }

    public List<BookingTicket> getBookingHistory() {
        return this.tickets;
    }
}
