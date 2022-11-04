package com.lowleveldesign.projects.bookmyshow.models;

import com.lowleveldesign.projects.bookmyshow.enums.PricePlan;

import java.util.HashMap;
import java.util.Map;

public class Theater {
    private String id;
    private String address;
    private String city;
    private Map<String,Screen> screens;
    public Theater(String id, String address, String city) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.screens = new HashMap<>();
    }

    public void addScreen(String id, int numSeats, PricePlan pricePlan) {
        this.screens.put(id, new Screen(id, numSeats, pricePlan, this));
    }

    public String getId() {
        return id;
    }

    public Screen getScreenById(String screenId) {
        return this.screens.get(screenId);
    }

    public boolean isScreenPresent(String screenId) {
        return this.screens.containsKey(screenId);
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
