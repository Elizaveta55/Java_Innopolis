package com.pattern;

public class TurnOnLightCommand extends Command {
    private Light light;


    public TurnOnLightCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.turnIn();
    }
}
