package com.lowleveldesign.projects.parkinglot.concrete;

import com.lowleveldesign.projects.parkinglot.enums.ParkingStrategyType;
import com.lowleveldesign.projects.parkinglot.enums.PaymentStrategyType;
import com.lowleveldesign.projects.parkinglot.enums.VehicleType;
import com.lowleveldesign.projects.parkinglot.interfaces.ParkingSpot;
import com.lowleveldesign.projects.parkinglot.interfaces.ParkingStrategy;
import com.lowleveldesign.projects.parkinglot.interfaces.PaymentStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<String,ParkingTicket> parkingTickets;
    private ParkingStrategyFactory parkingStrategyFactory;
    private PaymentStrategyFactory paymentStrategyFactory;
    private ParkingSpotService parkingSpotService;
    private static ParkingLot instance;
    private ParkingLot(Map<VehicleType, List<ParkingSpot>> parkingSpots) {
        this.parkingTickets = new HashMap<>();
        this.parkingSpotService = ParkingSpotService.getInstance(parkingSpots);
        parkingStrategyFactory = new ParkingStrategyFactory();
        paymentStrategyFactory = new PaymentStrategyFactory();
    }

    public static ParkingLot getInstance(Map<VehicleType, List<ParkingSpot>> parkingSpots) {
        if(ParkingLot.instance == null) {
            synchronized (ParkingLot.class) {
                ParkingLot.instance = new ParkingLot(parkingSpots);
            }
        }

        return ParkingLot.instance;
    }

    public ParkingTicket getParkingTicket(String vehicleNumber, VehicleType vehicleType, ParkingStrategyType parkingStrategyType) {
        List<ParkingSpot> parkingSpots = parkingSpotService.getAvailableParkingSpotsForVehicleType(vehicleType);
        ParkingStrategy parkingStrategy = parkingStrategyFactory.getParkingStrategy(parkingStrategyType);
        ParkingSpot allotedParkingSpot = parkingStrategy.getParkingSpot(parkingSpots);

        if(allotedParkingSpot == null) {
            System.out.println("Garage is full !");
            return null;
        }

        ParkingTicket parkingTicket = new ParkingTicket(allotedParkingSpot, vehicleNumber, vehicleType);
        this.parkingTickets.put(vehicleNumber, parkingTicket);

        return parkingTicket;
    }

    public void exitParkingLot(String vehicleNumber, PaymentStrategyType paymentStrategyType) {
        ParkingTicket allotedParkingTicket = this.parkingTickets.get(vehicleNumber);
        this.parkingTickets.remove(vehicleNumber);
        allotedParkingTicket.departure(this.parkingSpotService);
        double totalAmount = allotedParkingTicket.getTotalTicketCharge();
        PaymentStrategy paymentStrategy = this.paymentStrategyFactory.getPaymentStrategy(paymentStrategyType);
        paymentStrategy.processPayment(totalAmount);
    }
}
