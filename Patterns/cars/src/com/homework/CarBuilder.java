package com.homework;

public class CarBuilder extends Builder {

    @Override
    public Vehicle build() {
        Car car = new Car();
        car.setElectronics();
        car.setSteeringWheels();
        car.setEngine();
        car.setSuspension();
        car.setWheels();

        return car;
    }
}
