package BankSystem;

import BankSystem.Client.Client;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    public static String name;
    public int totalAmountOfMoney;

    public List<Client> Clients = new ArrayList<>();
    public List<Account> Accounts = new ArrayList<>();

    public void AddNewClient(Client client){
        Clients.add(client);
    }

    public void RemoveClient(Client client){
        Clients.remove(client);
    }

    public Account CreateAccount(Client client, String type){
        Account account = new Account(client, type);
        Accounts.add(account);

        return account;
    }


    public EventLogger CreateLogger(){
        return new EventLogger();
    }


}
