package com.company;

import java.time.LocalDate;

public abstract class VehicleSwim extends Vehicle implements IMoveNew {
    public VehicleSwim(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void moveSpecific() {
        System.out.println("Move by swimming");
    }
}
