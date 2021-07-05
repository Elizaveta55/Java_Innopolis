package BankSystem.Client;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RegularClient extends Client {

    //violation of Liskov substitution principle (class should have implementation/logic in methods)
    //violation of single responsibility principle (here realization of logic from another class)
    @Override
    public void MakeClientVip(Client client) {
        throw new NotImplementedException();
    }
}
