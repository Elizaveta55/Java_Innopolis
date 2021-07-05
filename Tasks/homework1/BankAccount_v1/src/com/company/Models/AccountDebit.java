package com.company.Models;

public class AccountDebit extends Account {

    //class constructor calls constructor of super-class
    public AccountDebit(double sum, int clientId) {
        super(sum, clientId);
    }

    //there is no necessity in overriding commands inside method, that is why super-class' method is called directly here
    @Override
    public boolean withdraw(double money) {
        return super.withdraw(money);
    }

    //there is no necessity in overriding commands inside method, that is why super-class' method is called directly here
    @Override
    public boolean deposit(double money) {
        return super.deposit(money);
    }

    //there is no necessity in overriding commands inside method, that is why super-class' method is called directly here
    @Override
    public boolean transfer(Account toAccount, String typeOfClient) {
        return super.transfer(toAccount, typeOfClient);
    }
}
