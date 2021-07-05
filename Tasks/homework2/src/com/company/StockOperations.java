package com.company;

//interface of typical actions of Stock class
public interface StockOperations {
    void addInventary(Inventory inventory, Integer integer);

    void deleteInventary(Inventory inventory, Integer integer);

    Inventory findById(int id); // return inventary found by its number
}
