package com.lowleveldesign.projects.carrental.services;

import com.lowleveldesign.projects.carrental.models.Car;
import com.lowleveldesign.projects.carrental.models.CarFilter;
import com.lowleveldesign.projects.carrental.models.Location;
import com.lowleveldesign.projects.carrental.repository.DataStore;
import java.util.List;

public class CarService {
    private static CarService instance;
    private DataStore dataStore;
    private CarService() {
        this.dataStore = DataStore.getInstance();
    }
    public static CarService getInstance() {
        if(CarService.instance == null) {
            synchronized(CarService.class) {
                CarService.instance = new CarService();
            }
        }

        return CarService.instance;
    }

    public List<Car> getCarsNearLocationByFilter(Location location, CarFilter carFilter) {
        return this.dataStore.getCarsByFilter(location, carFilter);
    }
}
