package BankSystem;

import BankSystem.Client.Client;
import BankSystem.Client.VipClient;
/*
It might be 3 types of account business, credit and debit (regular)
 */
//need to implement interface(or interfaces) to prevent appearing of "heavy" class, also to control logic
public class Account {

    // strong dependency, violation of dependency inversion principle
    // violation of single responsibility: it is better to have common logger in bank class
    private EventLogger eventLogger = new EventLogger();

    //violation of OOP encapsulation: fields should not be available outside of class (and child classes), therefore the implementation of detters and setter are needed
    // why account id is static? It should not be static
    // id is supposed to be int or long type, but in this task String type is also valid (due to using ArrayList as a data storage (not DB) and possibility to find client through ArrayList index)
    public static String accountId;
    public static int lastId = 0;
    // why balance is static? It should not be static
    public static double balance = 0;

    // why static? It should not be static
    public static String accountType;
    // quite strong dependency, violation of dependency inversion principle
    // why static? It should not be static
    public static Client accountClient;


    public Account(Client client, String type){
        Account.lastId++;
        accountType = type;
        accountId = new Integer(Account.lastId).toString();
        accountClient = client;
    }

    // where is any contracts to check, for example, that amount of money is positive
    public void Deposit(double money){
        balance += money;
        this.eventLogger.Log("Deposit");
    }

    // where is any contracts to check, for example, that amount of money is positive
    // violation of open close principle
    // due to different implementation of Withdraw operation in different account's types
    // therefore the implementation of children classes is needed, therefore there is a violation of OOP inheritance
    public boolean Withdraw(double money){
        if (accountType == "credit"){
            balance -= money;
            this.eventLogger.Log("Withdraw");
            return true;
        }

        if (balance >= money){
            balance -= money;
            this.eventLogger.Log("Withdraw");
            return true;
        }

        return false;
    }

    // where is any contracts to check, for example, that amount of money is positive
    // violation of open close principle
    // due to different implementation of Transfer operation in different account's types
    public void Transfer(Account account, double money) {

        if (accountType == "business") {
            if (accountClient instanceof VipClient) {
                if (this.Withdraw(money)) {
                    account.Deposit(money);
                    eventLogger.Log("Transfer");
                }
                return;
            } else {
                //for clear logic it is better to withdraw full amount of money, and then extract some fee
                if (this.Withdraw(money * 1.02)) {
                    account.Deposit(money);
                    eventLogger.Log("Transfer");
                }
            }

            return;
        }


        if (this.Withdraw(money)) {
            account.Deposit(money);
            eventLogger.Log("Transfer");
        }
    }

}
