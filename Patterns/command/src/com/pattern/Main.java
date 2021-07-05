package com.pattern;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command commandUp = new TurnOnLightCommand(light);
        Command commandDown = new TurnOutLightCommand(light);

        Switch sw = new Switch(commandUp, commandDown);

        sw.flipUp();
        sw.flipDown();
    }
}
