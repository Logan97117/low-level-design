package com.lowleveldesign.projects.bookmyshow;

import java.util.List;

public class BookingService {
    private DataRepository dataRepository;
    private PaymentService paymentService;
    private static BookingService instance;

    private BookingService() {
        this.dataRepository = DataRepository.getInstance();
        this.paymentService = new PaymentService();
    }

    public static BookingService getInstance() {
        if(BookingService.instance == null) {
            synchronized(BookingService.class) {
                BookingService.instance = new BookingService();
            }
        }

        return BookingService.instance;
    }

    public void lockSeats(User user, MovieShowSearchResult movieShowSearchResult, List<Integer> seats) {
        this.dataRepository.lockSeats(user, movieShowSearchResult, seats);
    }

    public BookingTicket bookSeats(User user, MovieShowSearchResult movieShowSearchResult, List<Integer> seats) {
        //call payment service
        BookingTicket ticket = this.dataRepository.bookSeats(user, movieShowSearchResult, seats);
        return ticket;
    }
}
