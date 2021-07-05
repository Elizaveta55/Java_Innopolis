package com.exam.demo;

public class TurnOutBackLightCommand implements Command {
    private BackLights light;


    public TurnOutBackLightCommand(BackLights light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.turnOffBack();
    }
}
