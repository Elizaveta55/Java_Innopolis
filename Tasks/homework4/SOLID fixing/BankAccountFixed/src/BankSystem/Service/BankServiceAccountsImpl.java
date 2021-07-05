package BankSystem.Service;

import BankSystem.Account.Account;
import BankSystem.Account.AccountBusiness;
import BankSystem.Account.AccountCredit;
import BankSystem.Account.AccountDebit;
import BankSystem.Bank.Bank;
import BankSystem.Client.Client;
import BankSystem.Client.RegularClient;
import BankSystem.Client.VipClient;

import static BankSystem.Bank.Bank.eventLogger;

public class BankServiceAccountsImpl implements IBankServiceAccounts {
    private Bank bank;

    // constructor with initialization of single field - Bank representing BankService
    public BankServiceAccountsImpl(Bank bank) {
        this.bank = bank;
    }


    // area of realization of all logic hidden from user by this abstraction
    @Override
    public void createNewAccount(int clientId, String type) {
        Account account;
        Client client = this.findClientById(clientId);
        switch (type) {
            case "Debit":
                account = new AccountDebit(client);
                break;
            case "Credit":
                account = new AccountCredit(client);
                break;
            case "Business":
                account = new AccountBusiness(client);
                break;
            default:
                throw new IllegalArgumentException("No correct value of type");
        }
        this.bank.addAccount(account);
        client.addAccount(account);
    }


    @Override
    public Account findAccountById(int id) {
        try {
            return this.bank.getAccounts().get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            eventLogger.log("The account ID is not correct");
            throw new IllegalArgumentException("The account ID is not correct");
        }
    }

    private Client findClientById(int id) {
        try {
            return this.bank.getClients().get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            eventLogger.log("The account ID is not correct");
            throw new IllegalArgumentException("The client ID is not correct");
        }
    }
}
