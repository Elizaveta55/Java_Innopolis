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

public class BankServiceClientsImpl implements IBankServiceClients {

    private Bank bank;

    // constructor with initialization of single field - Bank representing BankService
    public BankServiceClientsImpl(Bank bank) {
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
    public Client findClientById(int id) {
        try {
            return this.bank.getClients().get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            eventLogger.log("The account ID is not correct");
            throw new IllegalArgumentException("The client ID is not correct");
        }
    }

}
