package com.pattern;

public class Switch {
    private Command turnOn;
    private Command turnOut;

    public Switch(Command turnOn, Command turnOut){
        this.turnOn = turnOn;
        this.turnOut = turnOut;
    }

    public void flipUp(){
        turnOn.execute();
    }

    public void flipDown(){
        turnOut.execute();
    }

}
