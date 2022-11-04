package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.exceptions.EntityNotFoundException;
import com.lowleveldesign.projects.bookmyshow.models.Show;
import com.lowleveldesign.projects.bookmyshow.models.User;

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

    public void selectSeats(String userId, String showId , List<Integer> seats) {
        Show show = this.dataRepository.getShowById(showId);

        if(show == null)
            throw new EntityNotFoundException("Show with given ID does not exist");

        if(show.selectSeats(userId, seats))
            System.out.println("Seats selected successfully");
        else
            System.out.println("Seats selected are not currently available");
    }

    public BookingTicket bookSeats(String userId, String showId, List<Integer> seats) {
        Show show = this.dataRepository.getShowById(showId);
        User user = this.dataRepository.getUserById(userId);

        if(show == null)
            throw new EntityNotFoundException("Show with given ID does not exist");

        if(user == null)
            throw new EntityNotFoundException("User with givem ID does not exist");

        int cost  = show.bookSeats(userId, seats);
        //call payment service
        BookingTicket ticket = new BookingTicket(this.dataRepository.getShowById(showId), seats, cost);
        user.addBookingHistory(ticket);
        return ticket;
    }
}
