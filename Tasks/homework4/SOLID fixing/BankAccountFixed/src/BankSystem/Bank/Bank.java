package BankSystem.Bank;

import BankSystem.Account.Account;
import BankSystem.Client.Client;
import BankSystem.Settings.EventLogger;
import BankSystem.Settings.ILogger;

import java.util.ArrayList;
import java.util.List;

// Class is responsible only for actions associated with this class, therefore S principle is not violated
public class Bank implements IBankOperationsWithAccounts, IBankOperationsWithClients {

    // dependency is not strong by using an Interface, therefore D principle is not violated
    // making logger a single for all classes
    public final static ILogger eventLogger = EventLogger.getInstance();
    private String name;
    private int totalAmountOfMoney;
    // dependency is not strong by using an Abstract class, therefore D principle is not violated
    private List<Client> clients;
    // dependency is not strong by using an Abstract class, therefore D principle is not violated
    private List<Account> accounts;

    // constructor with initialization
    public Bank(String name) {
        this.name = name;
        this.totalAmountOfMoney = 0;
        this.clients = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    //area of getters
    public List<Client> getClients() {
        return clients;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    //implementation of interfaces methods
    @Override
    public void addNewClient(Client client) {
        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);

    }


}
