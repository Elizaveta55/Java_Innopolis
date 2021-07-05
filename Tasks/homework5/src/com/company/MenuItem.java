package com.company;

//in diagram there was no any constructor therefore in this class there is no constructors
//we can easily achieve adding or receiving value of some field by applying getters and setter
public abstract class MenuItem {
    private String name;
    private float price;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
