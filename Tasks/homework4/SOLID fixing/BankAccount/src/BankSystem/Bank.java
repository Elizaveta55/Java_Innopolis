package BankSystem;

import BankSystem.Client.Client;

import java.util.ArrayList;
import java.util.List;

//need to implement two interfaces (if there would be one interface, there will be a violation of interface segregation principle)
public class Bank {

    //violation of OOP encapsulation: fields should not be available outside of class (and child classes), therefore the implementation of getters and setter are needed
    // why static? Is it rather possible for name of bank to exist without actual bank?
    public static String name;
    public int totalAmountOfMoney;

    public List<Client> Clients = new ArrayList<>();
    public List<Account> Accounts = new ArrayList<>();

    // should be in interface IBankOperationsWithClients
    public void AddNewClient(Client client){
        Clients.add(client);
    }
    // should be in interface IBankOperationsWithClients
    public void RemoveClient(Client client){
        Clients.remove(client);
    }
    // should be in interface IBankOperationsWithAccounts
    public Account CreateAccount(Client client, String type){
        Account account = new Account(client, type);
        Accounts.add(account);
        return account;
    }

    //violation of single responsibility principle, bank should not be responsible for creating logger
    // solution - add it through constructor
    public EventLogger CreateLogger(){
        return new EventLogger();
    }


}
