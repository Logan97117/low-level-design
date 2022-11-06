package com.lowleveldesign.projects.carrental.services;

import com.lowleveldesign.projects.carrental.repository.DataStore;

public class AdminService {
    private DataStore dataStore;
    private static AdminService instance;
    private AdminService() {
        this.dataStore = DataStore.getInstance();
    }

    public static AdminService getInstance() {
        if(AdminService.instance == null) {
            synchronized(AdminService.class) {
                AdminService.instance = new AdminService();
            }
        }

        return AdminService.instance;
    }

    //add cars, stations, cars to stations
}
