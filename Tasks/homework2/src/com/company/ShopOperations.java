package com.company;

//describes all main actions of shop
public interface ShopOperations {
    void addConsumer(Consumer consumer); // method of adding new saler in list of consumers

    void addCustomer(Customer customer); // method of adding new buyer in list of customers

    void addInventary(Inventory inventory, Category category, int amount); // method of adding new inventory with its amount in stock of the same category

    void removeInventary(Inventory inventory, Category category, int amount); // method of removing some amount of inventory from the stock

    void addOrder(Order order); // method of adding new order in list of orders

    void makeReport(); // method for printing
}
