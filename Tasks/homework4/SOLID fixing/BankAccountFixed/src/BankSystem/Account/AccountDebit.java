package BankSystem.Account;

import BankSystem.Client.Client;


public class AccountDebit extends Account {
    // constructor with initialization of super-class's fields
    // which invokes constructor of super-class
    public AccountDebit(Client client) {
        super(client);
    }
}
