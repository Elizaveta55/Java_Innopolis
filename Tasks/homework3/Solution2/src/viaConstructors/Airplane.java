package viaConstructors;

import java.time.LocalDate;

public class Airplane extends Vehicle {
    public Airplane(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Move by flying");
    }
}
