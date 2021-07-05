package BankSystem.Account;

import BankSystem.Client.Client;
import BankSystem.Client.IClient;

import static BankSystem.Bank.Bank.eventLogger;

//abstract class of all account types, implement typical account's operations, therefore O principle is not violated
// Class is responsible only for actions associated with this class, therefore S principle is not violated
public abstract class Account implements IAccountOperations {

    // protected to make it available for children
    protected String accountId;
    // static field for controlling accounts ID
    protected static int lastId = 0;
    protected double balance;
    protected IClient accountClient;

    // constructor with initialization of its fields
    public Account(Client client) {
        Account.lastId++;
        this.accountId = Integer.toString(Account.lastId);
        this.accountClient = client;
        this.balance = 0;
    }

    //no unnecessary getters and setters

    //area of implementation of common operations for all accounts types
    @Override
    public void deposit(double money) {
        balance += money;
        eventLogger.log("Deposit " + money + " dollars in " + this.accountId + " account; Owner: " + accountClient.toString());
    }

    @Override
    public boolean withdraw(double money) {
        if (balance >= money) {
            balance -= money;
            eventLogger.log("Withdraw " + money + " dollars from " + this.accountId + " account; Owner: " + accountClient.toString());
            return true;
        }
        return false;
    }

    @Override
    public void transfer(Account account, double money) {
        try {
            if (this.withdraw(money)) {
                account.deposit(money);
                eventLogger.log("Transfer" + " from " + this.accountId + " account to " + account.accountId + " account;");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Bad news!");
        }
    }

    @Override
    public String toString() {
        return "Account " + this.getClass().getSimpleName() + "; balance: " + this.balance;
    }
}
