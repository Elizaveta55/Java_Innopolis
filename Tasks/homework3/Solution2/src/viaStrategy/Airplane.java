package viaStrategy;

import java.time.LocalDate;

public class Airplane extends Vehicle {
    public Airplane(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate, new MoveByFly());
    }
}
