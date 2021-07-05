package com.exam.demo;

public class TurnOnBackLightCommand implements Command {
    private BackLights light;


    public TurnOnBackLightCommand(BackLights light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.turnInBack();
    }
}
