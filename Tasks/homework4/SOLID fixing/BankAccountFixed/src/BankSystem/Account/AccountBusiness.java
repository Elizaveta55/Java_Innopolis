package BankSystem.Account;

import BankSystem.Client.Client;
import BankSystem.Client.VipClient;

import static BankSystem.Bank.Bank.eventLogger;

public class AccountBusiness extends Account {
    // constructor with initialization of super-class's fields
    // which invokes constructor of super-class
    public AccountBusiness(Client client) {
        super(client);
    }

    // overriding method due to speciality of Transfer type account, don't demand any changing in parent class, therefore L principle is not violated
    @Override
    public void transfer(Account account, double money) {
        if (accountClient instanceof VipClient) {
            if (this.withdraw(money)) {
                account.deposit(money);
                eventLogger.log("Transfer" + " from " + this.accountId + " account to " + account.accountId + " account;");
            }
            return;
        } else {
            if (this.withdraw(money)) {
                account.deposit(money * 0.98);
                eventLogger.log("Transfer" + " from " + this.accountId + " account to " + account.accountId + " account;");
            }
        }
    }
}
