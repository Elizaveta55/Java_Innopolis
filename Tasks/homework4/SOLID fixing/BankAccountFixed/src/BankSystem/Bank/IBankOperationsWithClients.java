package BankSystem.Bank;

import BankSystem.Client.Client;

//interface for bank
// present methods associated with clients, therefore I principle is not violated
public interface IBankOperationsWithClients {

    void addNewClient(Client client);

    void removeClient(Client client);
}
