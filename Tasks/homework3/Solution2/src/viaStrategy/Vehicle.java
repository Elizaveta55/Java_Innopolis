package viaStrategy;

import java.time.LocalDate;

public abstract class Vehicle {
    protected String name;
    protected int weight;
    protected LocalDate releaseDate;
    private MoveVehicle moveVehicle;

    public Vehicle(String name, int weight, LocalDate releaseDate, MoveVehicle moveVehicle){
        this.name = name;
        this.weight = weight;
        this.releaseDate = releaseDate;
        this.moveVehicle = moveVehicle;
    }

    public MoveVehicle getMoveVehicle() {
        return moveVehicle;
    }

    public void setMoveVehicle(MoveVehicle moveVehicle) {
        this.moveVehicle = moveVehicle;
    }
}
