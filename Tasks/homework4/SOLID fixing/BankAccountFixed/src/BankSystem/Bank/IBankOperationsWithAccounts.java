package BankSystem.Bank;

import BankSystem.Account.Account;

//interface for bank
// present methods associated with accounts, therefore I principle is not violated
public interface IBankOperationsWithAccounts {
    void addAccount(Account account);
}
