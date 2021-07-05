package viaConstructors;

import java.time.LocalDate;

public class Ship extends Vehicle {
    public Ship(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Move by swimming");
    }
}
