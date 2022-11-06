package com.lowleveldesign.projects.carrental.models;

import com.lowleveldesign.projects.carrental.enums.*;

public class Car {
    private String id;
    private CarType carType;
    private String registrationNumber;
    private Integer numSeats;
    private TransmissionType transmissionType;
    private FuelType fuelType;
    private Integer age;
    private Integer kmsDriven;
    private Rating rating;
    private CarStatus carStatus;
    private Integer pricePerHour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(Integer kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Integer pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
