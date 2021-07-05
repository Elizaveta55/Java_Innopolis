package com.pattern;

public class Director {

    public void createWoman(Builder builder){
        builder.setName("Li");
        builder.setAge(15);
        builder.setHeight(200);
    }
}
