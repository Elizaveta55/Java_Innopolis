package com.exam.demo;

public class VolDecCommand implements Command {
    private Volume volume;

    public VolDecCommand(Volume volume) {
        this.volume = volume;
    }

    @Override
    public void execute() {
        volume.volDecr(volume.amount);
    }
}
