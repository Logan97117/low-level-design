package com.lowleveldesign.projects.carrental.repository;

import com.lowleveldesign.projects.carrental.enums.CarStatus;
import com.lowleveldesign.projects.carrental.enums.TripStatus;
import com.lowleveldesign.projects.carrental.exceptions.NoSuchEntityException;
import com.lowleveldesign.projects.carrental.models.*;
import com.lowleveldesign.projects.carrental.utils.DistanceCalculator;

import java.util.*;

public class DataStore {
    private Map<String, User> users;
    private Map<String, Car> cars;
    private Map<String, Station> stations;
    private Map<String, List<Booking>> userBookings;
    private Map<String,Booking> bookings;
    private static DataStore instance;
    private DataStore() {
        this.users = new HashMap<>();
        this.cars = new HashMap<>();
        this.stations = new HashMap<>();
        this.userBookings = new HashMap<>();
        this.bookings = new HashMap<>();
    }

    public static DataStore getInstance() {
        if(DataStore.instance == null) {
            synchronized(DataStore.class) {
                DataStore.instance = new DataStore();
            }
        }

        return DataStore.instance;
    }

    public List<Car> getCarsByFilter(Location location, CarFilter carFilter) {
        PriorityQueue<Car> result = new PriorityQueue<>(new Comparator<Car>(){
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getPricePerHour().compareTo(o2.getPricePerHour());
            }
        });

        for(Station station: this.stations.values()) {
            Location stationLocation = station.getLocation();

            if(carFilter.getWithinRadius() != null && DistanceCalculator.distanceCalculator(location, stationLocation) > carFilter.getWithinRadius())
                continue;

            for(Car car: station.getAllCars()) {
                if(car.getCarStatus() == CarStatus.NOT_AVAILABLE)
                    continue;

                if(carFilter.getCarType() != null && car.getCarType() != carFilter.getCarType())
                    continue;

                if(carFilter.getFuelType() != null && car.getFuelType() != carFilter.getFuelType())
                    continue;

                if(carFilter.getTransmissionType() != null && car.getTransmissionType() != carFilter.getTransmissionType())
                    continue;

                result.add(car);
            }
        }

        return new ArrayList<>(result);
    }

    public Booking getBookingById(String bookingId) {
        return this.bookings.get(bookingId);
    }

    public Booking createNewBooking(String userId, String carId, String startStationId, String dropStationId, Double securityAmount) {
        User user = this.users.get(userId);
        Car car = this.cars.get(carId);
        car.setCarStatus(CarStatus.NOT_AVAILABLE);
        Station startStation = this.stations.get(startStationId);
        Station dropStation = this.stations.get(dropStationId);

        if(user == null)
            throw new NoSuchEntityException("User with given ID does not exist");

        if(car == null)
            throw new NoSuchEntityException("Car with given ID does not exist");

        if(startStation == null)
            throw new NoSuchEntityException("Station with given ID does not exist");

        if(dropStation == null)
            throw new NoSuchEntityException("Station with given ID does not exist");

        Booking newBooking = new Booking(car, user, startStation, dropStation, securityAmount);
        this.userBookings.putIfAbsent(userId, new ArrayList<>());
        this.userBookings.get(userId).add(newBooking);
        String bookingId = newBooking.getId();
        this.bookings.put(bookingId, newBooking);
        return newBooking;
    }

    public void startTrip(String bookingId) {
        Booking booking = this.getBookingById(bookingId);

        if(booking == null)
            throw new NoSuchEntityException("Booking with given ID does not exist");

        booking.setTripStartTime(System.currentTimeMillis());
        Station startStation = booking.getStartStation();
        Car car = booking.getCar();
        startStation.removeCar(car);
    }

    public void endTrip(String bookingId) {
        Booking booking = this.getBookingById(bookingId);

        if(booking == null)
            throw new NoSuchEntityException("Booking with given ID does not exist");

        booking.setTripEndTime(System.currentTimeMillis());
        Station station = booking.getDropStation();
        Car car = booking.getCar();
        station.addCar(car);
    }
}
