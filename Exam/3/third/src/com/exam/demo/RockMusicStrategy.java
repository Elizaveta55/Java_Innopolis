package com.exam.demo;

public class RockMusicStrategy implements IMusicStartegy {
    @Override
    public void play(String type) {
        System.out.println("Im playing rock");
    }
}
