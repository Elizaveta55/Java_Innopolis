package BankSystem.Client;

public class VipClient extends Client {

    // violation of single responsibility principle
    // class should not implement logic of creation instances of the class inside that class
    @Override
    public void MakeClientVip(Client client) {

        if (client instanceof VipClient){
            return;
        }

        Client vipClient = new VipClient();
        vipClient.name = client.name;
        vipClient.birthday = client.birthday;
        vipClient.accounts = client.accounts;

        int index = this.Bank.Clients.indexOf(client);
        this.Bank.Clients.set(index,vipClient);
    }
}
