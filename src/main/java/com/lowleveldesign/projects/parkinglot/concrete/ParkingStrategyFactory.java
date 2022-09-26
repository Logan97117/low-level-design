package com.lowleveldesign.projects.parkinglot.concrete;

import com.lowleveldesign.projects.parkinglot.enums.ParkingStrategyType;
import com.lowleveldesign.projects.parkinglot.interfaces.ParkingStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingStrategyFactory {
    private Map<ParkingStrategyType, ParkingStrategy> parkingStrategyCache;
    public ParkingStrategyFactory() {
        parkingStrategyCache = new HashMap<>();
        parkingStrategyCache.put(ParkingStrategyType.RANDOM, new RandomParkingStrategy());
    }

    public void addNewParkingStrategy(ParkingStrategyType parkingStrategyType, ParkingStrategy parkingStrategy) {
        this.parkingStrategyCache.put(parkingStrategyType, parkingStrategy);
    }

    public ParkingStrategy getParkingStrategy(ParkingStrategyType parkingStrategyType) {
        return this.parkingStrategyCache.get(parkingStrategyType);
    }
}
