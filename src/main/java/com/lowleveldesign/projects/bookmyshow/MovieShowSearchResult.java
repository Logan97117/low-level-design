package com.lowleveldesign.projects.bookmyshow;

public class MovieShowSearchResult {
    private MovieShow movieShow;
    private Theater theater;
    private TheaterCollection theaterCollection;

    public MovieShowSearchResult(MovieShow movieShow, Theater theater, TheaterCollection theaterCollection) {
        this.movieShow = movieShow;
        this.theater = theater;
        this.theaterCollection = theaterCollection;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public Theater getTheater() {
        return theater;
    }

    public TheaterCollection getTheaterCollection() {
        return theaterCollection;
    }
}
