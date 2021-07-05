package com.company;

import java.time.LocalDate;

public abstract class VehicleFly extends Vehicle implements IMoveNew {

    public VehicleFly(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void moveSpecific() {
        System.out.println("Move by flying");
    }
}
