package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // also all comments is written in souts for convenience of reading in console what exactly is going on

        //Creating new Shop
        System.out.println("                          Creating new Shop...");
        Shop shop = new Shop("MegaDiversity", "Mirty town, Sakha(Yakutia) Republic");
        System.out.println("                          Creating new Consumers...");
        //Creating new Consumers (with normal behavior, i.e. no exceptions should be thrown)
        Consumer tempClient1 = new Consumer("Saler John", 44, true); //the saler is saved in new var for future order adding
        shop.addConsumer(tempClient1);
        shop.addConsumer(new Consumer("Saler William", 36, true));
        Consumer tempClient2 = new Consumer("Saler Diana", 89, false); //the saler is saved in new var for future order adding
        shop.addConsumer(tempClient2);
        shop.addConsumer(new Consumer("Saler Decklana", 50, false));
        shop.addConsumer(new Consumer("Saler Beth", 20, false));

        //Creating new Customers (with normal behavior, i.e. no exceptions should be thrown)
        System.out.println("                          Creating new Customers...");
        shop.addCustomer(new Customer("Arseniy", 44, true));
        shop.addCustomer(new Customer("Matwey", 12, true));
        shop.addCustomer(new Customer("Ignat", 6, true));
        shop.addCustomer(new Customer("Klava", 89, false));
        shop.addCustomer(new Customer("Ololo", 50, false));
        shop.addCustomer(new Customer("Olga", 20, false));

        //Adding new Inventaries (with normal behavior, i.e. no exceptions should be thrown)
        System.out.println("                          Creating new Inventaries...");
        shop.addInventary(new InventoryExpirationDate(Category.FOOD, "Pedigri", LocalDate.of(2020, 9, 10), LocalDate.of(2020, 10, 27), 70), Category.FOOD, 200);
        shop.addInventary(new InventoryExpirationDate(Category.FOOD, "Wiskas", LocalDate.of(2020, 9, 10), LocalDate.of(2020, 10, 27), 30), Category.FOOD, 10);
        shop.addInventary(new InventoryExpirationDate(Category.FOOD, "Rastishka", LocalDate.of(2020, 9, 10), LocalDate.of(2021, 10, 10), 50), Category.FOOD, 100);
        shop.addInventary(new InventoryExpirationDate(Category.FOOD, "Honey", LocalDate.of(2010, 9, 10), LocalDate.of(2020, 10, 12), 1300), Category.FOOD, 150);
        shop.addInventary(new InventoryExpirationDate(Category.PHARMACY, "Ascorbic acid", LocalDate.of(2020, 3, 10), LocalDate.of(2021, 10, 12), 150), Category.PHARMACY, 100);
        shop.addInventary(new InventoryExpirationDate(Category.PHARMACY, "Tokoferol asetat", LocalDate.of(2020, 3, 10), LocalDate.of(2021, 10, 12), 200), Category.PHARMACY, 300);
        shop.addInventary(new InventoryExpirationDate(Category.PHARMACY, "Tetracycline", LocalDate.of(2020, 4, 20), LocalDate.of(2020, 10, 30), 180), Category.PHARMACY, 400);
        shop.addInventary(new InventorySize(Category.CLOTHES, "Gucci t-short", LocalDate.of(2019, 10, 10), 48, 12999), Category.CLOTHES, 10);
        shop.addInventary(new InventorySize(Category.CLOTHES, "Gloria Jeans' t-short", LocalDate.of(2019, 10, 15), 48, 99), Category.CLOTHES, 1500);
        shop.addInventary(new InventorySize(Category.CLOTHES, "noname' swimming cap", LocalDate.of(2019, 10, 20), 56, 210), Category.CLOTHES, 500);

        System.out.println("                          Creating a report...");
        shop.makeReport();

        //Adding new orders (with normal behavior, i.e. no exceptions should be thrown)
        System.out.println("                          Creating orders...");
        tempClient1.createOrder(Category.FOOD, 0, 0, 5, shop);
        tempClient1.createOrder(Category.FOOD, 1, 1, 10, shop);
        tempClient1.createOrder(Category.FOOD, 2, 2, 15, shop);
        tempClient1.createOrder(Category.FOOD, 3, 3, 20, shop);
        tempClient1.createOrder(Category.PHARMACY, 0, 4, 25, shop);
        tempClient2.createOrder(Category.PHARMACY, 1, 5, 30, shop);
        tempClient2.createOrder(Category.PHARMACY, 2, 0, 35, shop);
        tempClient2.createOrder(Category.CLOTHES, 0, 1, 5, shop);
        tempClient2.createOrder(Category.CLOTHES, 1, 2, 40, shop);
        tempClient2.createOrder(Category.CLOTHES, 2, 3, 45, shop);

        System.out.println("                          Creating a report...");
        shop.makeReport();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                          Part of checking contracts"); // Adding consumers, customers, orders, inventories with incorrect parameters, i.e. exceptions should be thrown
        System.out.println("                          Adding person with null name");
        try {
            shop.addCustomer(new Customer("", 40, true));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding person with uncorrect age -4");
        try {
            shop.addConsumer(new Consumer("Mark", -4, true));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding person with uncorrect age 200");
        try {
            shop.addConsumer(new Consumer("Mark", 200, true));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding person under 18 y.o. as a saler");
        try {
            shop.addConsumer(new Consumer("Mark", 13, true));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with wrong inventory number. Tne number is bigger than amount of inventories");
        try {
            tempClient1.createOrder(Category.FOOD, 10, 3, 5, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with wrong inventory number. Tne number is negative");
        try {
            tempClient1.createOrder(Category.FOOD, -10, 3, 5, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with wrong customer number. Tne number is bigger than amount of clients");
        try {
            tempClient1.createOrder(Category.FOOD, 1, 10, 5, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with wrong customer number. Tne number is negative");
        try {
            tempClient1.createOrder(Category.FOOD, 1, -10, 5, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with wrong amount of items");
        try {
            tempClient1.createOrder(Category.FOOD, 1, 3, 100, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with negative amount of items");
        try {
            tempClient1.createOrder(Category.FOOD, 1, 3, -10, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with inventory hit its expiration date. Category: Food");
        try {
            shop.addInventary(new InventoryExpirationDate(Category.FOOD, "Milk", LocalDate.of(2019, 9, 10), LocalDate.of(2020, 9, 10), 30), Category.FOOD, 10);
            tempClient1.createOrder(Category.FOOD, 4, 3, 5, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("                          Adding order with inventory hit its expiration date. Category: Pharmacy");
        try {
            shop.addInventary(new InventoryExpirationDate(Category.PHARMACY, "Noshpa", LocalDate.of(2019, 9, 10), LocalDate.of(2020, 9, 10), 30), Category.PHARMACY, 10);
            tempClient1.createOrder(Category.PHARMACY, 3, 3, 5, shop);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }


    }
}
