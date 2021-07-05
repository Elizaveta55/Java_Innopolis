package com.exam;

public abstract class Duck extends Animal {
    private ISwimmable swimmable;
    private IFlyable flyable;


    public void setSwimmable(ISwimmable swimmable) {
        this.swimmable = swimmable;
    }

    public void setFlyable(IFlyable flyable) {
        this.flyable = flyable;
    }

    public void swim(){
        this.swimmable.swim();
    }

    public void fly(){
        this.flyable.fly();
    }
}
