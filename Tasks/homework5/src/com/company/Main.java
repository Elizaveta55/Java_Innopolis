package com.company;

public class Main {
    public static void main(String[] args) {

        //creating main product
        Cappuccino cappuccino = new Cappuccino();
        cappuccino.setName("I'm cappuccino");
        cappuccino.setPrice(100);

        //creating complementary product
        //Sugar sugar = new Sugar();
        //sugar.setName("Sugar!");
        //sugar.setPrice(2);

        //creating complementary product
        Milk milk = new Milk();
        milk.setName("Milk");
        milk.setPrice(30);

        //creating new order
        //the first row displays creation of main order
        //the second row displays further addiction of complementary products
        MenuOrder menuOrder = new MenuOrder(cappuccino, 1);
        new MenuOrder(menuOrder, milk, 1);

        //showing order's cost
        System.out.println(menuOrder.calculateCost());
    }
}
