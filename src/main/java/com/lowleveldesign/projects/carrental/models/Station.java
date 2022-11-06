package com.lowleveldesign.projects.carrental.models;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String id;
    private String address;
    private String pinCode;
    private Location location;
    private List<Car> cars;

    public Station(String id, String address, String pinCode, Location location) {
        this.id = id;
        this.address = address;
        this.pinCode = pinCode;
        this.location = location;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void removeCar(Car car) {
        this.cars.remove(car);
    }

    public List<Car> getAllCars() {
        return this.cars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
