package com.company.Models;

import java.util.Date;

//class representing one account's operation
public class Operation {
    private String name; // name of operation: creation, withdraw, deposit or tranfer
    private double amount; // sum of operation
    private Date date;

    //more appropriate String format of class
    @Override
    public String toString() {
        return "type= " + name + '\'' +
                "; amount=" + amount +
                "; date=" + date +
                '\n';
    }

    //constructor
    public Operation(String name, double amount, Date date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }


}
