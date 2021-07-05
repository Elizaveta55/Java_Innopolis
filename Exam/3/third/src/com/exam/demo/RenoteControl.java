package com.exam.demo;

public class RenoteControl {
    private Command turnOnLight;
    private Command turnOutLight;
    private Command turnOnBackLight;
    private Command turnOutBackLight;
    private Command increaseVolume;
    private Command decreaseVolume;

    private IMusicStartegy musicStartegy;

    public RenoteControl(Command turnOn, Command turnOut, Command turnOnBackLight, Command turnOutBackLight,Command increaseVolume, Command decreaseVolume, IMusicStartegy music){
        this.turnOnLight = turnOn;
        this.turnOutLight = turnOut;
        this.turnOnBackLight = turnOnBackLight;
        this.turnOutBackLight = turnOutBackLight;
        this.increaseVolume = increaseVolume;
        this.decreaseVolume = decreaseVolume;
        this.musicStartegy = music;
    }

    public void setMusicStartegy(IMusicStartegy musicStartegy) {
        this.musicStartegy = musicStartegy;
    }

    public void lightUp(){
        turnOnLight.execute();
    }

    public void LighDown(){
        turnOutLight.execute();
    }

    public void BackLighDown(){
        turnOutBackLight.execute();
    }
    public void BackLighUP(){
        turnOnBackLight.execute();
    }
    public void volDown(){
        decreaseVolume.execute();
    }
    public void volUp(){
        increaseVolume.execute();
    }
}
