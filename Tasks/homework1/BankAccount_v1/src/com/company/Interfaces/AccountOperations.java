package com.company.Interfaces;

import com.company.Models.Account;

public interface AccountOperations { //interface for all types of accounts: regular, golden or VIP

    boolean withdraw(double money);

    boolean deposit(double money);

    boolean transfer(Account toAccount, String typeOfClient); // String typeOfClient is necessary for fee calculation
}
