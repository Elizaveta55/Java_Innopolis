package BankSystem;

import BankSystem.Client.Client;
import BankSystem.Client.VipClient;
/*
It might be 3 types of account business, credit and debit (regular)
 */
public class Account {

    private EventLogger eventLogger = new EventLogger();

    public static String accountId;
    public static int lastId = 0;
    public static double balance = 0;

    public static String accountType;
    public static Client accountClient;

    public Account(Client client, String type){
        Account.lastId++;
        accountType = type;
        accountId = new Integer(Account.lastId).toString();
        accountClient = client;
    }

    public void Deposit(double money){
        balance += money;
        this.eventLogger.Log("Deposit");
    }

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

    public void Transfer(Account account, double money) {

        if (accountType == "business") {
            if (accountClient instanceof VipClient) {
                if (this.Withdraw(money)) {
                    account.Deposit(money);
                    eventLogger.Log("Transfer");
                }
                return;
            } else {
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
