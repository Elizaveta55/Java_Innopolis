package BankSystem.Client;


import BankSystem.Account.Account;

import java.util.ArrayList;
import java.util.List;

// A common abstract class for all clients, therefore O principle is not violated
// Class is responsible only for actions associated with this class, therefore S principle is not violated
public abstract class Client implements IClient {

    protected String name;
    protected String birthday;
    protected String gender;
    // dependency is not strong by using an Abstract class, therefore D principle is not violated
    protected List<Account> accounts;

    // constructor with initialization of its fields
    public Client(String name, String birthday, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.accounts = new ArrayList<>();
    }

    //implementation of interfaces methods
    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "Client: Name: " + this.name + "; birthday: " + this.birthday + "; gender: " + this.gender + "; accounts: " + accounts.toString();
    }
}
