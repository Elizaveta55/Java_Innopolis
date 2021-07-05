package BankSystem.Service;

import BankSystem.Account.Account;
import BankSystem.Bank.Bank;

import static BankSystem.Bank.Bank.eventLogger;

public class BankServiceOperationsImpl implements IBankServiceOperations {

    private Bank bank;

    // constructor with initialization of single field - Bank representing BankService
    public BankServiceOperationsImpl(Bank bank) {
        this.bank = bank;
    }


    // area of realization of all logic hidden from user by this abstraction
    @Override
    public void doDeposit(int accountId, double money) {
        if (money < 0) throw new IllegalArgumentException("No correct value of amount of money");
        Account account = this.findAccountById(accountId);
        account.deposit(money);
    }

    @Override
    public void doWithdraw(int accountId, double money) {
        if (money < 0) throw new IllegalArgumentException("No correct value of amount of money");
        Account account = this.findAccountById(accountId);
        account.withdraw(money);
    }

    @Override
    public void doTransfer(int fromAccountId, int toAccountId, double money) {
        if (money < 0) throw new IllegalArgumentException("No correct value of amount of money");
        Account accountFrom = this.findAccountById(fromAccountId);
        Account accountTo = this.findAccountById(toAccountId);
        accountFrom.transfer(accountTo, money);
    }

    private Account findAccountById(int id) {
        try {
            return this.bank.getAccounts().get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            eventLogger.log("The account ID is not correct");
            throw new IllegalArgumentException("The account ID is not correct");
        }
    }

}
