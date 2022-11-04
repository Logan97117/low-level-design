package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.enums.PricePlan;
import com.lowleveldesign.projects.bookmyshow.exceptions.EntityNotFoundException;
import com.lowleveldesign.projects.bookmyshow.models.*;

import java.util.*;

public class DataRepository {
    private static DataRepository instance;
    private Map<String,List<Theater>> theaters;
    private Map<String, Movie> movies;
    private Map<String, Show> shows;
    private Map<String,User> users;
    private DataRepository() {
        this.theaters = new HashMap<>();
        this.movies = new HashMap<>();
        this.shows = new HashMap<>();
        this.users = new HashMap<>();
    }

    public static DataRepository getInstance() {
        if(DataRepository.instance == null) {
            synchronized(DataRepository.class) {
                DataRepository.instance = new DataRepository();
            }
        }

        return DataRepository.instance;
    }

    public User getUserById(String id) {
        return this.users.get(id);
    }

    public void addUser(String id, String firstName, String lastName) {
        this.users.put(id, new User(id,firstName, lastName));
    }

    public List<Theater> getTheatersByCity(String cityName) {
        if(!theaters.containsKey(cityName))
            return new ArrayList<>();

        return theaters.get(cityName);
    }

    public Movie getMovieById(String movieId) {
        return movies.get(movieId);
    }

    public Show getShowById(String showId) {
        return shows.get(showId);
    }

    public void addTheater(String id, String address, String city) {
        theaters.putIfAbsent(city, new ArrayList<>());
        theaters.get(city).add(new Theater(id, address, city));
    }

    public void addScreen(String theaterId, String id, int numSeats, PricePlan pricePlan) {
        Theater theater = getTheaterById(theaterId);

        if(theater == null)
            throw new EntityNotFoundException("Theater not found with given ID");

        theater.addScreen(id, numSeats, pricePlan);
    }

    public Theater getTheaterById(String theaterId) {
        for(List<Theater> theaters: theaters.values()) {
            for(Theater currTheater: theaters) {
                if(currTheater.getId().equals(theaterId))
                    return currTheater;
            }
        }

        return null;
    }

    public void addShow(String theaterId, String showId,  String movieId, String screenId, Date startDateTime) {
        Movie movie = movies.get(movieId);
        Theater theater = getTheaterById(theaterId);

        if(movie == null || theater == null)
            throw new EntityNotFoundException("Movie with given ID not found");

        Screen screen = theater.getScreenById(screenId);

        if(screen == null)
            throw new EntityNotFoundException("Screen with given ID not found");

        Show show = new Show(showId , movie, screen, startDateTime);
        this.shows.put(showId, show);
    }

    public List<Show> getShowsForMovie(String movieId, String cityName) {
        List<Show> results = new ArrayList<>();
        for(Show show: this.shows.values()) {
            if(show.getMovie().getId().equals(movieId) && show.getScreen().getTheater().getCity().equals(cityName.toLowerCase()))
                results.add(show);
        }

        return results;
    }
}
