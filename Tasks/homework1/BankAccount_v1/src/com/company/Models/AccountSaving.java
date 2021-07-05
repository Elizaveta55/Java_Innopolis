package com.company.Models;

import java.util.Date;

public class AccountSaving extends Account {
    private Date date; //date of creating account
    private int amountOfMins; //amounts of minutes for which operation "withdraw" is not available. There is supposed to be months, but it's quite long for checking))

    //class constructor calls constructor of super-class
    //and identify date of creation
    public AccountSaving(double sum, int clientId, int amountOfMins) {
        super(sum, clientId);
        this.date = new Date();
        this.amountOfMins = amountOfMins;
    }

    //before going into super-class method there is a verification rather necessary time have passed
    @Override
    public boolean withdraw(double money) {
        Date nowDate = new Date();
        long difference = nowDate.getTime() - this.date.getTime();
        if (difference < amountOfMins * 60000) return false;
        else return super.withdraw(money);
    }

    //there is no necessity in overriding commands inside method, that is why super-class' method is called directly here
    @Override
    public boolean deposit(double money) {
        return super.deposit(money);
    }

    //there is no necessity in overriding commands inside method, that is why super-class' method is called directly here
    @Override
    public boolean transfer(Account toAccount, String typeOfClient) {
        /*
        Date nowDate = new Date();
        long difference = nowDate.getTime() - this.date.getTime();
        if (difference < amountOfMins * 60000) return false;
        else
        */
            return super.transfer(toAccount, typeOfClient);
    }
}
