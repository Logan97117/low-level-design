package com.lowleveldesign.projects.carrental.models;

import com.lowleveldesign.projects.carrental.enums.CarType;
import com.lowleveldesign.projects.carrental.enums.FuelType;
import com.lowleveldesign.projects.carrental.enums.TransmissionType;

public class CarFilter {
    private CarType carType;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private Integer withinRadius;

    public Integer getWithinRadius() {
        return withinRadius;
    }

    public CarFilter(CarType carType, FuelType fuelType, TransmissionType transmissionType, Integer withinRadius) {
        this.carType = carType;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.withinRadius = withinRadius;
    }

    public CarType getCarType() {
        return carType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
