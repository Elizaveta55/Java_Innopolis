package com.company.Interfaces;

import com.company.Models.Account;
import com.company.Models.Client;
import com.company.Models.Operation;

import java.util.ArrayList;

public interface BankOperations { //interface of all basic operations of class Bank

    void add(Client client); //add client in bank

    void createAccount(int clientId, int typeOfAccount, double sum); //create an account of client

    ArrayList<Client> clientsList(); //return list of all bank's clients

    ArrayList<Account> accountsList(); //return list of all bank's accounts

    ArrayList<Account> accountsListOfClient(int clientId); //return list of all bank's client's accounts

    ArrayList<Operation> operationsList(int accountId, int clientId); //return list of operations performed on the client's account
}
