package BankSystem.Service;

import BankSystem.Service.toDelete.IBankService;

// interface presenting actions connected with bank's operations, therefore I principle is not violated
// created for abstraction
public interface IBankServiceOperations {
    void doDeposit(int accountId, double money);

    void doWithdraw(int accountId, double money);

    void doTransfer(int fromAccountId, int toAccountId, double money);
}
