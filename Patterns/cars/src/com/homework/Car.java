package com.homework;

public class Car implements IVehicle {

    public void setSuspension(){
        System.out.println("Was set");
    }

    public void setWheels(){
        System.out.println("Suspension was set");
    }

    public void setEngine(){
        System.out.println("Engine was set");
    }

    public void setElectronics(){
        System.out.println("Was set");
    }

    public void setSteeringWheels(){
        System.out.println("Was set");
    }

    @Override
    public void move() {
        System.out.println("I'm riding");
    }
}
