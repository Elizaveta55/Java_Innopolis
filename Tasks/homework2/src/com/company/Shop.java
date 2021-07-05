package com.company;

import java.util.ArrayList;

//representation of shop
public class Shop implements ShopOperations {
    private String name;
    private String location;
    private ArrayList<Consumer> consumers;
    private ArrayList<Customer> customers;
    private ArrayList<Stock> stocks;
    private ArrayList<Order> orders;

    //constructor with initialization
    public Shop(String name, String location) {
        this.name = name;
        this.location = location;
        this.consumers = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.stocks = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    //area of necessary getters
    //no setters are needed
    public ArrayList<Stock> getStocks() {
        return this.stocks;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //implementation of interface's methods
    @Override
    public void addConsumer(Consumer consumer) {
        consumers.add(consumer);
    }

    //implementation of interface's methods
    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //implementation of interface's methods
    @Override
    public void addInventary(Inventory inventory, Category category, int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("No correct value of amount"); //check rather amount is positive
        for (Stock stock : stocks) {
            if (stock.getCategory().equals(category)) { //searching for appropriate stock
                stock.addInventary(inventory, amount);
                return; // if stock is found then 'return' is implied
            }
        }
        Stock newStock = new Stock(category); // if stock is not found then new one should be created
        newStock.addInventary(inventory, amount);
        stocks.add(newStock);
    }

    //implementation of interface's methods of deleting/decrementing item from stock
    @Override
    public void removeInventary(Inventory inventory, Category category, int amount) {
        for (Stock stock : stocks) {
            if (stock.getCategory().equals(category)) {
                stock.deleteInventary(inventory, amount);
            }
        }
    }

    //implementation of interface's methods
    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    //method for printing
    // which shows all customers, consumers, orders and stocks with inventories
    @Override
    public void makeReport() {
        System.out.println("REPORT:");
        System.out.println("Shop's name: " + this.name);
        System.out.println("Shop's location: " + this.location);
        System.out.println("List of customers: ");
        for (Customer customer : this.customers) {
            System.out.println(customer.toString());
        }
        System.out.println("List of consumers: ");
        for (Consumer consumer : consumers) {
            System.out.println(consumer.toString());
        }
        System.out.println("List of stocks: ");
        for (Stock stock : stocks) {
            System.out.println(stock.toString());
        }
        System.out.println("List of orders: ");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

}
