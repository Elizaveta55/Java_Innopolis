package com.company;

import java.time.LocalDate;

public class Ship extends VehicleSwim {
    public Ship(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }
}
