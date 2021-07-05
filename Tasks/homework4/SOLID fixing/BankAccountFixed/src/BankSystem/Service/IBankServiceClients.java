package BankSystem.Service;

import BankSystem.Client.Client;
import BankSystem.Service.toDelete.IBankService;

// interface presenting actions connected with bank's clients, therefore I principle is not violated
// created for abstraction
public interface IBankServiceClients {
    void createNewClient(String name, String type, String birthday, String gender);

    Client findClientById(int id);
}
