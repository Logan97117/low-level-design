package com.lowleveldesign.projects.parkinglot.interfaces;

import com.lowleveldesign.projects.parkinglot.enums.AdditionalServiceType;

public interface ParkingSpot {
    public void lockParkingSpot();
    public void resetParkingSpot();
    public void additionalServices(AdditionalServiceType serviceType);
    public double getTotalTariff(long timeInMilliseconds);
}
