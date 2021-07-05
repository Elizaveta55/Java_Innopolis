package com.company;

import java.time.LocalDate;

// 'Inventory' with additional field (Size) for Clothes category
public class InventorySize extends Inventory {
    private int size;

    //constructor adding size and invoking super-class constructor
    public InventorySize(Category category, String name, LocalDate creationDate, int size, int price) {
        super(category, name, creationDate, price);
        this.size = size;
    }

    //area of necessary getters
    public int getSize() {
        return size;
    }

    //override method of transferring instance into string type for printing
    @Override
    public String toString() {
        return "Inventary{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
