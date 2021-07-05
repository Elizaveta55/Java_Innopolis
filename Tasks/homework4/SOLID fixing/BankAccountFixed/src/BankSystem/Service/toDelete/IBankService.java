package BankSystem.Service.toDelete;

import BankSystem.Account.Account;
import BankSystem.Client.Client;

// common abstraction, therefore O principle is not violated
//  with trivial/simple usage in main() by using only single instance 'bankService' for all operations
// but IBankService has became to heavy, therefore there is violation of I principle
// interface should be split into 3 interfaces
public interface IBankService {
    /*
    void createNewAccount(int clientId, String type);
    Account findAccountById(int id);

    void createNewClient(String name, String type, String birthday, String gender);
    Client findClientById(int id);

    void doDeposit(int accountId, double money);
    void doWithdraw(int accountId, double money);
    void doTransfer(int fromAccountId, int toAccountId, double money);

     */
}
