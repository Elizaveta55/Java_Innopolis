package com.company.Models;

import com.company.Interfaces.AccountOperations;

import java.util.ArrayList;
import java.util.Date;

public class Account implements AccountOperations {

    private int clientId; //number of client who possess that particular account
    private double sum;
    private ArrayList<Operation> operations; //list of operations performed on the account

    public Account(double sum, int clientId) { //constructor
        this.clientId = clientId;
        this.sum = sum;
        operations = new ArrayList<Operation>();
        this.addOperation("Creation", sum, new Date()); // adding operation of creation in list of operations performed on the account
    }

    // area of getters and setter, here are pointed only those that were used in program
    public double getSum() {
        return sum;
    }
    public int getClientId() {
        return clientId;
    }
    public void setSum(double newSum) {
        this.sum = newSum;
    }
    public ArrayList<Operation> getOperations() {
        return operations;
    }

    //method for adding operation since class property is protected
    public void addOperation(String name, double amountOfMoney, Date date) {
        operations.add(new Operation(name, amountOfMoney, date));
    }

    //overriding of withdraw operation for all subclasses of that class
    @Override
    public boolean withdraw(double money) {
        if (sum < money) return false; //withdraw sum should not be more than account's sum
        else {
            sum = sum - money;
            this.addOperation("Withdraw", money, new Date());
            return true;
        }
    }

    //overriding of deposit operation for all subclasses of that class
    @Override
    public boolean deposit(double money) {
        sum += money;
        this.addOperation("Deposit", money, new Date());
        return true;
    }

    //overriding of transfer operation for all subclasses of that class
    @Override
    public boolean transfer(Account toAccount, String typeOfClient) {
        toAccount.deposit(this.sum);
        this.addOperation("Transfer", sum, new Date());
        sum = 0;
        return true;
    }
}
