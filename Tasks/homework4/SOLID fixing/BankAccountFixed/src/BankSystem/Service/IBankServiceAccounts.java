package BankSystem.Service;

import BankSystem.Account.Account;
import BankSystem.Service.toDelete.IBankService;

// interface presenting actions connected with bank's accounts, therefore I principle is not violated
// created for abstraction
public interface IBankServiceAccounts {
    void createNewAccount(int clientId, String type);

    Account findAccountById(int id);
}
