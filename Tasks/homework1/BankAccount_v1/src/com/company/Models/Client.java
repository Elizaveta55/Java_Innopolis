package com.company.Models;

import java.util.ArrayList;
import java.util.Date;

//class of client
public class Client {
    private String name;
    private Date date;
    private boolean isMale;
    private int amountOfMoney;
    private int amountOfAccounts;
    private ArrayList<Account> accounts; // list of client's accounts


    //constructor
    public Client(String name, Date date, boolean isMale) {
        this.name = name;
        this.date = date;
        this.isMale = isMale;
        this.amountOfMoney = 0;
        this.amountOfAccounts = 0;
        this.accounts = new ArrayList<Account>();
    }

    //area of necessary getters and setters
    public String getName() {
        return name;
    }
    public Date getDate() {
        return date;
    }
    public boolean getIsMale() {
        return isMale;
    }

    public long getAmountOfMoney() {
        this.updateClientInfo();
        return amountOfMoney;
    }

    public int getAmountOfAccounts() {
        return amountOfAccounts;
    }

    //method of adding new client's account
    public void addAccount(Account account) {
        accounts.add(account);
        this.amountOfAccounts++;
        this.updateClientInfo();
    }

    //return all client's accounts
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    //return client's account by account number
    public Account getAccount(int accountId) {
        if (this.accounts.size() >= accountId && accountId > 0) return accounts.get(accountId - 1);
        else return null;
    }

    //method needed to update total amount of money after adding new accounts
    public void updateClientInfo() {
        int sum = 0;
        for (int i = 0; i < accounts.size(); i++) {
            sum += accounts.get(i).getSum();
        }
        this.amountOfMoney = sum;
    }
}
