package viaStrategy;

import java.time.LocalDate;

public class Car extends Vehicle {
    public Car(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate, new Move());
    }

}
