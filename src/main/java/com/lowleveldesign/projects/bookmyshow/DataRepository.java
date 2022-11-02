package com.lowleveldesign.projects.bookmyshow;

import java.util.List;

public class DataRepository {
    private static DataRepository instance;
    private MovieRepository movieRepository;
    private TheaterRepository theaterRepository;
    private DataRepository() {
        this.theaterRepository = TheaterRepository.getInstance();
        this.movieRepository = MovieRepository.getInstance();
    }

    public static DataRepository getInstance() {
        if(DataRepository.instance == null) {
            synchronized(DataRepository.class) {
                DataRepository.instance = new DataRepository();
            }
        }

        return DataRepository.instance;
    }

    public List<MovieShowSearchResult> getAllMovieShowsForMovie(String movieId) {
        return this.theaterRepository.getAllMovieShowsForMovie(movieId);
    }

    public void lockSeats(User user, MovieShowSearchResult movieShowSearchResult, List<Integer> seats) {
        movieShowSearchResult.getMovieShow().getSeatingArrangement().lockSeats(seats);
    }

    public BookingTicket bookSeats(User user, MovieShowSearchResult movieShowSearchResult, List<Integer> seats) { int totalCost = movieShowSearchResult.getMovieShow().getSeatingArrangement().bookSeatsAndReturnCost(user, seats);
       BookingTicket ticket = new BookingTicket(movieShowSearchResult.getMovieShow(), seats, totalCost);
       user.addBookingHistory(ticket);
       return ticket;

    }
}
