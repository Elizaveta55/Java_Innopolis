package com.company;

import java.time.LocalDate;

public class Inventory {
    //protected type is implied to give access to child classes
    protected Category category;
    protected String name;
    protected LocalDate creationDate;
    protected int price;

    //constructor with common commands for all kind of inventory
    public Inventory(Category category, String name, LocalDate creationDate, int price) {
        this.category = category;
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    //area of getters
    //no setters are needed
    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
