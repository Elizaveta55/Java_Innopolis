package com.pattern;

public class TurnOutLightCommand extends Command {
    private Light light;

    public TurnOutLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
