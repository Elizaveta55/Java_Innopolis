package com.homework;

public class AirBuilder extends Builder {


    @Override
    public Vehicle build() {
        Airplane airplane = new Airplane();
        airplane.setWings();
        airplane.setChaises();
        airplane.setAutoPlot();
        airplane.setEngine();
        airplane.setElectronics();
        return airplane;
    }
}
