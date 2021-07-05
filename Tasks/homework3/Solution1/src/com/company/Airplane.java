package com.company;

import java.time.LocalDate;

public class Airplane extends VehicleFlying {
    public Airplane(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }
}
