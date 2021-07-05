package com.company;

import java.time.LocalDate;

public abstract class VehicleFlying extends Vehicle implements MoveVehicleByFlying {
    public VehicleFlying(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void moveSpecific() {
        System.out.println("Move by flying");
    }
}
