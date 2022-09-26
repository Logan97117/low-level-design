package com.lowleveldesign.projects.parkinglot.concrete;

import com.lowleveldesign.projects.parkinglot.enums.AdditionalServiceType;
import com.lowleveldesign.projects.parkinglot.enums.VehicleType;
import com.lowleveldesign.projects.parkinglot.interfaces.ParkingSpot;

public class ParkingTicket {
    private ParkingSpot parkingSpot;
    private String registrationNumber;
    private VehicleType vehicleType;
    private long arrivalTime;
    private long departureTime;
    private double totalTicketCharge;
    public ParkingTicket(ParkingSpot parkingSpot, String registrationNumber, VehicleType vehicleType) {
        this.parkingSpot = parkingSpot;
        this.arrivalTime = System.currentTimeMillis();
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public void useAdditionalService(AdditionalServiceType serviceType) {
        this.parkingSpot.additionalServices(serviceType);
    }

    public void departure(ParkingSpotService parkingSpotService) {
        //Capture departure time
        this.departureTime = System.currentTimeMillis();

        //get total charge
        this.totalTicketCharge = this.parkingSpot.getTotalTariff(this.departureTime - this.arrivalTime);

        //reset the parking spot
        this.parkingSpot.resetParkingSpot();
        parkingSpotService.addParkingSpotBack(this.parkingSpot, this.vehicleType);
        this.parkingSpot = null;
        //Add reference to services which take care of all parking spots, available and occupied ones
        //Only those services can add or remove parking spots from occupied pool to unoccupied pool
    }

    public double getTotalTicketCharge() {
        return this.totalTicketCharge;
    }
}
