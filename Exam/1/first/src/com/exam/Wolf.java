package com.exam;

public class Wolf extends Animal {

    public void huntOn (Animal animal){
        System.out.println("Im hinting on " + animal.getClass().getSimpleName());
    }
}
