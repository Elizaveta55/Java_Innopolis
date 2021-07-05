package com.company.Models;

public class AccountBuisness extends Account { //subclass of Account class

    //class constructor calls constructor of super-class
    public AccountBuisness(double sum, int clientId) {
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

    //there is one additional action needed to transfer money for Business account
    //it placed right before calling super-class method
    @Override
    public boolean transfer(Account toAccount, String typeOfClient) {
        if (typeOfClient.equals("ClientRegular")) this.setSum(this.getSum()*0.98);
        else if (typeOfClient.equals("ClientGolden")) this.setSum(this.getSum()*0.99);
        else if (typeOfClient.equals("ClientVIP")) ;
        else throw new NullPointerException(); //in case of absence of necessary information in String typeOfClient
        return super.transfer(toAccount, typeOfClient);
    }
}
