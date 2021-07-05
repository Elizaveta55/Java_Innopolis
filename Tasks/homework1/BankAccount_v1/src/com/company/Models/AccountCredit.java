package com.company.Models;

import java.util.Date;

public class AccountCredit extends Account {

    //class constructor calls constructor of super-class
    public AccountCredit(double sum, int clientId) {
        super(sum, clientId);
    }

    //credit account allows to have negative value of sum, that is why method should be changed
    @Override
    public boolean withdraw(double money) {
        this.setSum(this.getSum() - money);
        this.addOperation("Withdraw", money, new Date());
        return true;
    }

    //there is no necessity in overriding commands inside method, that is why super-class' method is called directly here
    @Override
    public boolean deposit(double money) {
        return super.deposit(money);
    }

    //add a verification rather sum of account is positive to transfer money, then super-class method is called
    @Override
    public boolean transfer(Account toAccount, String typeOfClient) {
        if (this.getSum() < 0) return false;
        return super.transfer(toAccount, typeOfClient);
    }
}
