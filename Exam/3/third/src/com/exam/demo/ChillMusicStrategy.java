package com.exam.demo;

public class ChillMusicStrategy implements IMusicStartegy {
    @Override
    public void play(String type) {
        System.out.println("Im playing chill");
    }
}
