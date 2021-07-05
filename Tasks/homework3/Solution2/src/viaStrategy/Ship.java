package viaStrategy;

import java.time.LocalDate;

public class Ship extends Vehicle {
    public Ship(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate, new MoveBySwim());
    }
}
