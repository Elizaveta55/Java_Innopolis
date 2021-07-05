package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Nissan", 1000, LocalDate.of(2009, 12, 12)));
        vehicles.add(new Airplane("TU 154", 3000, LocalDate.of(1972, 2, 9)));
        vehicles.add(new Ship("Nevsky", 5000, LocalDate.of(1951, 7, 7)));
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass().getSimpleName() + ":");
            vehicle.move();
            if (vehicle instanceof VehicleFlying) {
                ((VehicleFlying) vehicle).moveSpecific();
            } else if (vehicle instanceof VehicleSwimming) {
                ((VehicleSwimming) vehicle).moveSpecific();
            }
            System.out.println();
        }
    }
}
