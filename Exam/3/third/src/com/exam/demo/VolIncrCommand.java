package com.exam.demo;

public class VolIncrCommand implements Command {

    private Volume volume;

    public VolIncrCommand(Volume volume) {
        this.volume = volume;
    }

    @Override
    public void execute() {
        volume.volIncr(volume.amount);
    }

}
