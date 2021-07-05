package viaMultipleInterfaces;

import java.time.LocalDate;

public class Ship extends Vehicle implements IMoveNew {
    public Ship(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void moveSpecific() {
        System.out.println("Move by swimming");
    }
}
