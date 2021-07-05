package com.company.Models;

import com.company.Interfaces.BankOperations;

import java.util.ArrayList;

//Class with almost all business logic
public class Bank implements BankOperations {

    private int id; // number of bank, in the program there is only one bank available
    private String name;
    private ArrayList<Client> clients; //list of all clients
    private ArrayList<Account> accounts; //list of all accounts
    private double totalAmount; // total amount of money of evety client
    private int amointOfBanks = 1;

    //constructor
    public Bank(String name) {
        this.id = amointOfBanks;
        this.name = name;
        this.clients = new ArrayList<Client>();
        this.accounts = new ArrayList<Account>();
        this.totalAmount = 0;
    }

    //area of necessary getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }
    public double getTotalAmount() {
        this.updateBankInfo();
        return totalAmount;
    }

    //method of updating total amount of money
    private void updateBankInfo() {
        int sum = 0;
        for (Account account : accounts) {
            sum += account.getSum();
        }
        this.totalAmount = sum;
    }

    //return information about bank itself
    public String getInfo() {
        return "Name: " + name + "; Amount of clients: " + clients.size() + "; Amount of accounts: " + accounts.size() + "; Amount of all money: " + this.getTotalAmount() + ";";
    }

    //return information about all bank's clients
    public String getClientInfo() {
        String gender;
        if (clients.size() == 0) return  "No clients"; //in case there is no clients yet
        String result = "";
        for (Client client : clients) {
            if (client.getIsMale()) gender = "Male";
            else gender = "Female";
            result = result + "Number of client: " + clients.indexOf(client) + "; Status: " + client.getClass().getSimpleName() + "; Name: " + client.getName() + "; Birthday: " + client.getDate() + "; Gender: " + gender + "; Amount of accounts: " + client.getAmountOfAccounts() + "; Total amount o money: " + client.getAmountOfMoney() + ";" + '\n';
        }
        return result;
    }

    //return information about all bank's accounts
    public String getAccountInfo() {
        if (accounts.size() == 0) return "No accounts"; //in case there is no accounts yet
        String result = "";
        for (Account temp : accounts) {
            result = result + "Owner's number: " + clients.indexOf(this.findClientByID(temp.getClientId())) + "; Owner's account number: " + this.findClientByID(temp.getClientId()).getAccounts().indexOf(temp) + "; Owner's name: " + this.findClientByID(temp.getClientId()).getName() + "; Sum: " + temp.getSum() + "; Status: " + temp.getClass().getSimpleName() + ";" + '\n';
        }
        return result;
    }

    //return information about some bank's client's accounts by client number
    public String getAccountsOfClientInfo(int ClientID) {
        String result = "";
        ArrayList<Account> current = this.accountsListOfClient(ClientID);
        if (current == null) return "No accounts yet";
        for (Account account : current) {
            result = result + "Account number: " + current.indexOf(account) + "; Sum: " + account.getSum() + "; Status: " + account.getClass().getSimpleName() + ";" + '\n';
        }
        return result;
    }

    //find bank's client by his number
    public Client findClientByID(int clientId) {
        if (clientId <= clients.size() && clientId > 0) return clients.get(clientId - 1);
        else return null;
    }

    //implementation of adding new clint
    @Override
    public void add(Client client) {
        clients.add(client);
        this.updateBankInfo();
    }

    //implementation of creating new account of the client
    @Override
    public void createAccount(int clientIdId, int typeOfAccount, double sum) {
        Client temp = clients.get(clientIdId - 1);
        Account newAccount;
        if (typeOfAccount == 1) newAccount = new AccountBuisness(sum, clientIdId); //validation rather type of account was entered correctly
        else if (typeOfAccount == 2) newAccount = new AccountCredit(sum, clientIdId);
        else if (typeOfAccount == 3) newAccount = new AccountDebit(sum, clientIdId);
        else if (typeOfAccount == 4) newAccount = new AccountSaving(sum, clientIdId, 2); //adding information about amount of minutes
        else {
            System.err.println("No correct value of account type");
            return;
        }
        temp.addAccount(newAccount);
        this.accounts.add(newAccount);
        this.updateBankInfo();
    }


    //implementation of returning list of all clients
    @Override
    public ArrayList<Client> clientsList() {
        return clients;
    }

    //implementation of returning list of all accounts
    @Override
    public ArrayList<Account> accountsList() {
        return this.accounts;
    }

    //implementation of returning list of all accounts of some client
    @Override
    public ArrayList<Account> accountsListOfClient(int clientId) {
        Client tempClient = clients.get(clientId - 1);
        return tempClient.getAccounts();
    }

    //implementation of returning list of all operations performed on the account of the client
    @Override
    public ArrayList<Operation> operationsList(int accountId, int clientId) {
        ArrayList<Operation> tempOperations = new ArrayList<Operation>();
        Account tempAccount = clients.get(clientId - 1).getAccount(accountId);
        tempOperations.addAll(tempAccount.getOperations());
        return tempOperations;
    }
}
