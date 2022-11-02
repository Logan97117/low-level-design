package com.lowleveldesign.projects.bookmyshow;

public class AdminService {
    private MovieRepository movieRepository;
    private TheaterRepository theaterRepository;
    private static AdminService instance;
    private AdminService() {
        this.movieRepository = MovieRepository.getInstance();
        this.theaterRepository = TheaterRepository.getInstance();
    }

    public static AdminService getInstance() {
        if(AdminService.instance == null) {
            synchronized(AdminService.class) {
                AdminService.instance = new AdminService();
            }
        }

        return AdminService.instance;
    }


}
