package com.exam.demo;

public class TurnOutLightCommand implements Command {
    private Light light;

    public TurnOutLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
