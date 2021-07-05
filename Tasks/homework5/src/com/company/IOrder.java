package com.company;

public interface IOrder {
    //for abstruct class these fields wouldn't be commented
    //while interfaces is not allowed to use private and not final-style fields
    /*
    private MenuItem menuItem;
    private int amount;
     */

    public float calculateCost();

    public MenuItem getMenuItem();

    public void setMenuItem(MenuItem menuItem);

    public int getAmount();

    public void setAmount(int amount);
}
