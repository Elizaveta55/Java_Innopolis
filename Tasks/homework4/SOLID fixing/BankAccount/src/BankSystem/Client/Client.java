package BankSystem.Client;


import BankSystem.Account;
import BankSystem.Bank;

import java.util.ArrayList;
import java.util.List;

//need to implement interface(or interfaces) to prevent appearing of "heavy" class, to control logic
public abstract class Client {

    //violation of OOP encapsulation: fields should not be available outside of class (and child classes), therefore the implementation of detters and setter are needed
    public String name;
    public String birthday;
    public String gender;

    //violation of OOP polymorphism (static): no constructors available (especially needed in case of using private\protected access modifiers)

    // strong dependency, violation of dependency inversion principle
    // no need to have field Bank here, therefore violation of single responsibility principle
    public BankSystem.Bank Bank;

    //in case this accounts belongs some client - presence of field is correct
    //in case there is all accounts of bank - presence of field is not corrent, violation of single responsibility principle
    public List<Account> accounts = new ArrayList<>();

    // violation of single responsibility principle: client should not create a new account, client should only add new account to the list of his accounts
    public Account CreateAccount(String type){
        Account account = new Account(this, type);
        accounts.add(account);

        return account;
    }


    // no correct logic, violation of single responsibility and Liskov principles (as a result)
    // client should not be responsible for creating it's children classes
    /*
    This method makes another client a VIP client
     */
    public abstract void MakeClientVip(Client client);


}
