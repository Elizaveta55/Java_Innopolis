package com.pattern;

public class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("Im HTML Button, Im here");
    }

    @Override
    public void onClick() {
        System.out.println("Hello, Im HTML Button");
    }
}
