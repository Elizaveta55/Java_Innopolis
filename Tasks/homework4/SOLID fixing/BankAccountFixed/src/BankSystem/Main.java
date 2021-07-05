package BankSystem;

import BankSystem.Bank.Bank;
import BankSystem.Service.*;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("The number one Bank");
        //creaing an interface for working with bank's accounts
        IBankServiceAccounts bankServiceAccounts = new BankServiceAccountsImpl(bank);
        //creaing an interface for working with bank's clients
        IBankServiceClients bankServiceClients = new BankServiceClientsImpl(bank);
        //creaing an interface for working with bank's operations
        IBankServiceOperations bankServiceOperations = new BankServiceOperationsImpl(bank);

        bankServiceClients.createNewClient("Lola", "Regular", "20.09.1999", "female");
        bankServiceClients.createNewClient("Lora", "Vip", "20.09.1999", "female");
        bankServiceClients.createNewClient("Losa", "Regular", "20.09.1990", "male");
        bankServiceClients.createNewClient("Lofa", "Vip", "20.09.1990", "male");

        bankServiceAccounts.createNewAccount(1, "Business");
        bankServiceAccounts.createNewAccount(2, "Business");
        bankServiceAccounts.createNewAccount(3, "Debit");
        bankServiceAccounts.createNewAccount(4, "Business");
        bankServiceAccounts.createNewAccount(1, "Debit");
        bankServiceAccounts.createNewAccount(2, "Credit");
        bankServiceAccounts.createNewAccount(3, "Credit");
        bankServiceAccounts.createNewAccount(4, "Business");
        bankServiceAccounts.createNewAccount(1, "Credit");

        bankServiceOperations.doDeposit(1, 100);
        bankServiceOperations.doDeposit(2, 200);
        bankServiceOperations.doDeposit(3, 300);
        bankServiceOperations.doDeposit(4, 400);
        bankServiceOperations.doDeposit(5, 500);
        bankServiceOperations.doDeposit(6, 600);
        bankServiceOperations.doDeposit(7, 700);
        bankServiceOperations.doDeposit(8, 800);
        bankServiceOperations.doDeposit(9, 900);
        System.out.println();

        bankServiceOperations.doWithdraw(1, 10);
        bankServiceOperations.doWithdraw(2, 20);
        bankServiceOperations.doWithdraw(3, 30);
        bankServiceOperations.doWithdraw(4, 40);
        bankServiceOperations.doWithdraw(5, 50);
        bankServiceOperations.doWithdraw(6, 60);
        bankServiceOperations.doWithdraw(7, 70);
        bankServiceOperations.doWithdraw(8, 80);
        bankServiceOperations.doWithdraw(9, 90);
        System.out.println();

        bankServiceOperations.doTransfer(1, 2, 1);
        bankServiceOperations.doTransfer(2, 3, 2);
        bankServiceOperations.doTransfer(3, 4, 3);
        bankServiceOperations.doTransfer(4, 5, 4);
        bankServiceOperations.doTransfer(5, 6, 5);
        bankServiceOperations.doTransfer(6, 7, 6);
        bankServiceOperations.doTransfer(7, 8, 7);
        bankServiceOperations.doTransfer(8, 9, 8);

        System.out.println();
        System.out.println("Check for some deails:");
        System.out.println("1. Credit might have negative balance:");
        bankServiceOperations.doWithdraw(6, 20000);
        bankServiceOperations.doTransfer(6, 7, 10000);
        bankServiceOperations.doWithdraw(8, 20000);

        System.out.println("2. Business fee exists:");
        bankServiceOperations.doDeposit(1, 2000);
        bankServiceAccounts.createNewAccount(2, "Credit");
        bankServiceOperations.doTransfer(1, 10, 1000);

        System.out.println("3. Wrong ID number will invoke exception:");
        try {
            bankServiceOperations.doWithdraw(80, 20);
        } catch (IllegalArgumentException e) {
            System.err.println("Warning!");
        }

    }
}
