package com.company;

//in diagram there was no any constructor,
// but in this class presence of constructors is necessary
public class MenuOrder implements IOrder {
    private MenuItem menuItem;
    private int amount;
    private MenuOrder order;

    //constructor for main order - cappuccino
    public MenuOrder(MenuItem menuItem, int amount) {
        this.menuItem = menuItem;
        this.amount = amount;
        this.order = null;
    }

    //constructor for supplementary addings of main order - sugar, milk
    public MenuOrder(MenuOrder order, MenuItem menuItem, int amount) {
        order.order = this; // firstly inserting into main order information about current supplementary order
        this.menuItem = menuItem; //then just initializing current supplementary product
        this.amount = amount;
        this.order = null;
    }

    @Override
    public float calculateCost() {
        float cost = this.getAmount() * this.getMenuItem().getPrice();
        if (this.getOrder() != null)
            cost += this.getOrder().calculateCost();
        return cost;
    }

    @Override
    public MenuItem getMenuItem() {
        return this.menuItem;
    }

    @Override
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }


    public MenuOrder getOrder() {
        return order;
    }

    public void setOrder(MenuOrder order) {
        this.order = order;
    }
}
