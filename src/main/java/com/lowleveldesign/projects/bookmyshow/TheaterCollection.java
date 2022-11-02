package com.lowleveldesign.projects.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterCollection {
    private String id;
    private String name;
    private Map<String,Theater> theaters;
    public TheaterCollection(String id, String name) {
        this.id = id;
        this.name = name;
        this.theaters = new HashMap<>();
    }

    public void addTheater(Theater theater) {
        this.theaters.put(theater.getId(), theater);
    }

    public Theater getTheaterById(String theaterId) {
        return this.theaters.get(theaterId);
    }

    public List<Theater> getAllTheaters() {
        return new ArrayList<>(this.theaters.values());
    }
}
