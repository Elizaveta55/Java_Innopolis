package com.pattern;

public class HumanBuilder implements Builder {
    private Human instance;

    public HumanBuilder() {
        this.instance = new Human();
    }

    @Override
    public void setName(String Name){
        instance.setName(Name);
    }

    @Override
    public void setAge(int age){
        instance.setAge(age);
    }

    @Override
    public void setHeight(int height){
        instance.setHeight(height);
    }

    @Override
    public Human build() {
        return instance;
    }
}
