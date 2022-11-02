package com.lowleveldesign.projects.bookmyshow;

import com.lowleveldesign.projects.bookmyshow.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterRepository {
    private Map<String,TheaterCollection> theaterCollection;
    private static TheaterRepository instance;
    private TheaterRepository() {
        this.theaterCollection = new HashMap<>();
    }

    public static TheaterRepository getInstance() {
        if(TheaterRepository.instance == null) {
            synchronized (TheaterRepository.class) {
                TheaterRepository.instance = new TheaterRepository();
            }
        }

        return TheaterRepository.instance;
    }

    public void addTheaterCollection(String theaterCollectionId, String name) {
        TheaterCollection theaterCollection = new TheaterCollection(theaterCollectionId, name);
        this.theaterCollection.put(theaterCollectionId, theaterCollection);
        return;
    }

    public void addTheater(String theaterCollectionId, String theaterId, int numSeats, Map<Integer,Integer> defaultPriceMap) {
        if(!this.theaterCollection.containsKey(theaterCollectionId))
            throw new EntityNotFoundException("Theater collection not found");

        Theater theater = new Theater(theaterId, numSeats, defaultPriceMap);
        this.theaterCollection.get(theaterCollectionId).addTheater(theater);
        return;
    }

    public void addMovieShow(String theaterCollectionId, String theaterId, Integer startTime, Movie movie, Map<Integer,Integer> rowPriceMap) {
        if(!this.theaterCollection.containsKey(theaterCollectionId))
            throw new EntityNotFoundException("Theater collection not found");

        if(this.theaterCollection.get(theaterCollectionId).getTheaterById((theaterId)) == null)
            throw new EntityNotFoundException("Theater with given ID not found");

        this.theaterCollection.get(theaterCollectionId).getTheaterById(theaterId).addMovieShow(movie, startTime, rowPriceMap);
    }

    public void addMovieShow(String theaterCollectionId, String theaterId, Integer startTime, Movie movie) {
        if(!this.theaterCollection.containsKey(theaterCollectionId))
            throw new EntityNotFoundException("Theater collection not found");

        if(this.theaterCollection.get(theaterCollectionId).getTheaterById((theaterId)) == null)
            throw new EntityNotFoundException("Theater with given ID not found");

        this.theaterCollection.get(theaterCollectionId).getTheaterById(theaterId).addMovieShow(movie, startTime);
    }

    public List<MovieShowSearchResult> getAllMovieShowsForMovie(String movieId) {
        List<MovieShowSearchResult> movieShowSearchResults = new ArrayList<>();

        for(TheaterCollection theaterCollection: theaterCollection.values()) {
            List<Theater> theaters = theaterCollection.getAllTheaters();
            for(Theater theater: theaters) {
                List<MovieShow> currentShows = theater.getMovieShowsByMovieId(movieId);
                for(MovieShow movieShow: currentShows)
                    movieShowSearchResults.add(new MovieShowSearchResult(movieShow, theater, theaterCollection));
            }
        }

        return movieShowSearchResults;
    }
}
