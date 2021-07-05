package com.company;

import java.time.LocalDate;

//class for consumer's and customer's orders
public class Order {
    private LocalDate date;
    private Inventory inventory;
    private Consumer consumer;
    private Customer customer;
    private int price;
    private int amount;

    //constructor with initializing of all field
    public Order(Inventory inventory, Consumer consumer, Customer customer, int price, int amount) {
        this.date = LocalDate.now();
        this.inventory = inventory;
        this.consumer = consumer;
        this.customer = customer;
        this.price = price;
        this.amount = amount;
    }

    //override method of transferring instance into string type for printing
    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", inventary=" + inventory +
                ", consumer=" + consumer +
                ", customer=" + customer +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
