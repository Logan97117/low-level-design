package com.lowleveldesign.projects.parkinglot.interfaces;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot getParkingSpot(List<ParkingSpot> parkingSpots);
}
