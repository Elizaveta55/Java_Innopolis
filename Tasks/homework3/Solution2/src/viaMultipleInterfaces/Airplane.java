package viaMultipleInterfaces;

import java.time.LocalDate;

public class Airplane extends Vehicle implements IMoveNew {
    public Airplane(String name, int weight, LocalDate releaseDate) {
        super(name, weight, releaseDate);
    }

    @Override
    public void moveSpecific() {
        System.out.println("Move by flying");
    }
}
