package viaConstructors;

import java.time.LocalDate;

public abstract class Vehicle implements MoveVehicle {
    protected String name;
    protected int weight;
    protected LocalDate releaseDate;

    public Vehicle(String name, int weight, LocalDate releaseDate){
        this.name = name;
        this.weight = weight;
        this.releaseDate = releaseDate;
    }

    @Override
    public void move() {
        System.out.println("Base kind of movement");
    }
}
