package BankSystem.Service.toDelete;

import BankSystem.Account.Account;
import BankSystem.Account.AccountBusiness;
import BankSystem.Account.AccountCredit;
import BankSystem.Account.AccountDebit;
import BankSystem.Bank.Bank;
import BankSystem.Client.Client;
import BankSystem.Client.RegularClient;
import BankSystem.Client.VipClient;
import BankSystem.Service.IBankServiceAccounts;
import BankSystem.Service.IBankServiceClients;
import BankSystem.Service.IBankServiceOperations;

import static BankSystem.Bank.Bank.eventLogger;

// class created for abstraction of bank logic, implements all BankService's interfaces
public class IBankServiceImpl implements IBankServiceAccounts, IBankServiceClients, IBankServiceOperations {

    private Bank bank;

    // constructor with initialization of single field - Bank representing BankService
    public IBankServiceImpl(Bank bank) {
        this.bank = bank;
    }


    // area of realization of all logic hidden from user by this abstraction
    @Override
    public void createNewClient(String name, String type, String birthday, String gender) {
        Client client;
        switch (type) {
            case "Regular":
                client = new RegularClient(name, birthday, gender);
                break;
            case "Vip":
                client = new VipClient(name, birthday, gender);
                break;
            default:
                throw new IllegalArgumentException("No correct value of type");
        }
        this.bank.addNewClient(client);
    }

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
    public void doDeposit(int accountId, double money) {
        Account account = this.findAccountById(accountId);
        account.deposit(money);
    }

    @Override
    public void doWithdraw(int accountId, double money) {
        Account account = this.findAccountById(accountId);
        account.withdraw(money);
    }

    @Override
    public void doTransfer(int fromAccountId, int toAccountId, double money) {
        Account accountFrom = this.findAccountById(fromAccountId);
        Account accountTo = this.findAccountById(toAccountId);
        accountFrom.transfer(accountTo, money);
    }

    @Override
    public Client findClientById(int id) {
        try {
            return this.bank.getClients().get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            eventLogger.log("The account ID is not correct");
            throw new IllegalArgumentException("The client ID is not correct");
        }
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
}
