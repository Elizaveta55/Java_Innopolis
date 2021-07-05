package com.company;

import java.time.LocalDate;

public abstract class VehicleSwimming extends Vehicle implements MoveVehicleBySwimming {
    public VehicleSwimming(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void moveSpecific() {
        System.out.println("Move by swimming");
    }
}
