package com.company;

import java.time.LocalDate;

// 'Inventory' with additional field (ExpirationDate) for Food and Pharmacy category
public class InventoryExpirationDate extends Inventory {
    private LocalDate expirationDate;

    //constructor adding ExpirationDate and invoking super-class constructor
    public InventoryExpirationDate(Category category, String name, LocalDate creationDate, LocalDate expirationDate, int price) {
        super(category, name, creationDate, price);
        this.expirationDate = expirationDate;
    }

    //area of necessary getters
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    //override method of transferring instance into string type for printing
    @Override
    public String toString() {
        return "Inventary{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                '}';
    }
}
