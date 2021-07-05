package BankSystem.Client;


import BankSystem.Account;
import BankSystem.Bank;

import java.util.ArrayList;
import java.util.List;

public abstract class Client {

    public String name;
    public String birthday;
    public String gender;

    public BankSystem.Bank Bank;

    public List<Account> accounts = new ArrayList<>();


    public Account CreateAccount(String type){
        Account account = new Account(this, type);
        accounts.add(account);

        return account;
    }


    /*
    This method makes another client a VIP client
     */
    public abstract void MakeClientVip(Client client);


}
