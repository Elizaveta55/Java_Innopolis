package BankSystem.Account;

import BankSystem.Bank.Bank;
import BankSystem.Client.Client;

public class AccountCredit extends Account {

    // constructor with initialization of super-class's fields
    // which invokes constructor of super-class
    public AccountCredit(Client client) {
        super(client);
    }

    // overriding method due to speciality of Credit type account, don't demand any changing in parent class, therefore L principle is not violated
    @Override
    public boolean withdraw(double money) {
        balance -= money;
        Bank.eventLogger.log("Withdraw " + money + " dollars from " + this.accountId + " account; Owner: " + accountClient.toString());
        return true;
    }
}
