package com.company;

import com.company.Models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//RB: Good work and you did not forget about comments
//Grade 100
public class Main {

    public static void main(String[] args) {
        //create an entity of Bank
        Bank bank = new Bank("ООО 'Give Me Your Money' Бaнk");
        //create parse format for date
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);

        //some initial clients and their accounts for convenience
        bank.add(new ClientVIP("Pavel Vip", new Date(1998, 10, 20), true));
        bank.add(new ClientRegular("Eleonora Regul", new Date(1975, 6, 20), false));
        bank.add(new ClientGolden("Alexandr Gold", new Date(2000, 12,12), true));
        //some initial accounts of the first client;
        //1- Buisness, 2- Credit, 3- Debit, 4 - Saving
        bank.createAccount(1, 1,1000);
        bank.createAccount(1, 2,1000);
        //some initial accounts of the second client;
        //1- Buisness, 2- Credit, 3- Debit, 4 - Saving
        bank.createAccount(2, 2,1000);
        bank.createAccount(2, 3,1000);
        //some initial accounts of the third client;
        //1- Buisness, 2- Credit, 3- Debit, 4 - Saving
        bank.createAccount(3, 3,1000);
        bank.createAccount(3, 4,1000);
        bank.createAccount(3, 1,1000);

        //initialize console command menu
        int command = 1;
        while (command != 0) {
            System.out.println("Choose one from following operation:");
            System.out.println("1 - Request Bank information");
            System.out.println("2 - Request Bank's accounts information");
            System.out.println("3 - Request Bank's clients information");
            System.out.println("4 - Begin Session with Client");
            System.out.println("0 - Exit");
            int comand = scanner.nextInt();
            switch (comand) {
                case 1:
                    System.out.println(bank.getInfo());
                    break;
                case 2:
                    System.out.println(bank.getAccountInfo());
                    break;
                case 3:
                    System.out.println(bank.getClientInfo());
                    break;
                case 4:
                    System.out.println("Choose one from following operation:");
                    System.out.println("1 - Add client");
                    System.out.println("2 - Add client's account");
                    System.out.println("3 - Withdraw from client's account");
                    System.out.println("4 - Deposit to client's account");
                    System.out.println("5 - Transfer from one client's account to another account");
                    System.out.println("6 - Transfer from one client's account to another client's account");
                    System.out.println("7 - List of operations performed on client's account");
                    System.out.println("8 - List of client's accounts");
                    System.out.println("0 - Back");
                    int comandClient = scanner.nextInt();
                    switch (comandClient) {
                        case 1:
                            System.out.println("Enter client's name");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            System.out.println("Enter client's birthday in following format: dd.mm.YYYY");
                            Date date;
                            try {
                                date = sdf.parse(scanner.next());
                            } catch (ParseException e) {
                                System.err.println("No correct value of date"); // making sure of correct value of birthday, otherwise display error message
                                break;
                            }
                            System.out.println("Enter client's gender: 0-F, 1-M");
                            int genderInt = scanner.nextInt();
                            boolean gender;
                            if (genderInt == 0) gender = false;
                            else if (genderInt == 1) gender = true;
                            else {
                                System.err.println("No correct value of gender"); // making sure of correct value of gender, otherwise display error message
                                break;
                            }
                            System.out.println("Enter client's type: 1- Regular, 2- Golden, 3- VIP");
                            int type = scanner.nextInt();
                            if (type == 1) bank.add(new ClientRegular(name, date, gender));
                            else if (type == 2) bank.add(new ClientGolden(name, date, gender));
                            else if (type == 3) bank.add(new ClientVIP(name, date, gender));
                            else {
                                System.err.println("No correct value of client type"); // making sure of correct value of client's type, otherwise display error message
                                break;
                            }
                            break;
                        case 2:
                            System.out.println("Enter client's ID");
                            int clientIdForAccountCreation = scanner.nextInt();
                            Client currentClientForAccountCreation = bank.findClientByID(clientIdForAccountCreation);//search client for account adding by ID
                            if (currentClientForAccountCreation != null) {
                                System.out.println("Enter initial amount of money on account");
                                double sum = scanner.nextDouble();
                                if (sum < 0) {
                                    System.err.println("No correct value of sum"); // making sure of correct value of sum, otherwise display error message
                                    break;
                                }
                                System.out.println("Enter account's type: 1- Buisness, 2- Credit, 3- Debit, 4 - Saving");
                                int typeOfAccount = scanner.nextInt();
                                bank.createAccount(clientIdForAccountCreation, typeOfAccount, sum);
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 3:
                            System.out.println("Enter client's ID");
                            int clientIDForWithdraw = scanner.nextInt();
                            Client currentClientForWithdraw = bank.findClientByID(clientIDForWithdraw);//search for client for withdraw operation by number
                            if (currentClientForWithdraw != null) {
                                System.out.println("Enter account's number");
                                int tempAccount = scanner.nextInt();
                                Account account = currentClientForWithdraw.getAccount(tempAccount); //search for client's account by its number
                                if (account != null) {
                                    System.out.println("Enter amount of money on account for withdraw");
                                    double sum = scanner.nextDouble();
                                    if (sum < 0) {
                                        System.err.println("No correct value of sum"); // making sure of correct value of sum, otherwise display error message
                                        break;
                                    }
                                    if (account.withdraw(sum)) //verification rather operation was done
                                        System.out.println("     Successfully");
                                    else
                                        System.out.println("     NOT Successfully");
                                } else {
                                    System.err.println("No account found"); // making sure of correct value of client's account number, otherwise display error message
                                    break;
                                }
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 4:
                            System.out.println("Enter client's ID");
                            int clientIDForDeposit = scanner.nextInt();
                            Client currentClientForDeposit = bank.findClientByID(clientIDForDeposit);//search for client for deposit operation by number
                            if (currentClientForDeposit != null) {
                                System.out.println("Enter account's number");
                                int tempAccount = scanner.nextInt();
                                Account account = currentClientForDeposit.getAccount(tempAccount); //search for client's account by its number
                                if (account != null) {
                                    System.out.println("Enter amount of money on account for deposit");
                                    double sum = scanner.nextDouble();
                                    if (sum < 0) {
                                        System.err.println("No correct value of sum"); // making sure of correct value of sum, otherwise display error message
                                        break;
                                    }
                                    if (account.deposit(sum)) //verification rather operation was done
                                        System.out.println("     Successfully");
                                    else
                                        System.out.println("     NOT Successfully");
                                } else {
                                    System.err.println("No account found"); // making sure of correct value of client's account number, otherwise display error message
                                    break;
                                }
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 5:
                            System.out.println("Enter client's ID");
                            int clientIDForTransfer = scanner.nextInt();
                            Client currentClientForTransfer = bank.findClientByID(clientIDForTransfer); //search for client for transfer operation by number
                            if (currentClientForTransfer != null) {
                                System.out.println("Enter account's number for 'Withdraw'");
                                int tempAccount = scanner.nextInt();
                                System.out.println("Enter account's number for 'Deposit'");
                                int tempAccountToTranfer = scanner.nextInt();
                                Account account = currentClientForTransfer.getAccount(tempAccount); //search for client's first account by its number
                                Account accountToTransfer = currentClientForTransfer.getAccount(tempAccountToTranfer); //search for client's second account by its number
                                if (account != null && accountToTransfer != null) {
                                    if (account.transfer(accountToTransfer, currentClientForTransfer.getClass().getSimpleName())) //verification rather operation was done
                                        System.out.println("     Successfully");
                                    else
                                        System.out.println("     NOT Successfully");
                                } else {
                                    System.err.println("No account found"); // making sure of correct value of client's account number, otherwise display error message
                                    break;
                                }
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 6:
                            System.out.println("Enter 'withdraw' client's ID");
                            int clientIDForTransferToAnotherClientFirst = scanner.nextInt();
                            Client currentClientForTransferToAnotherClientFirst = bank.findClientByID(clientIDForTransferToAnotherClientFirst); //search for first client for transfer operation by number
                            System.out.println("Enter 'deposit' client's ID");
                            int clientIDForTransferToAnotherClientSecond = scanner.nextInt();
                            Client currentClientForTransferToAnotherClientSecond = bank.findClientByID(clientIDForTransferToAnotherClientSecond); //search for second client for transfer operation by number
                            if (currentClientForTransferToAnotherClientFirst != null && currentClientForTransferToAnotherClientSecond != null) {
                                System.out.println("Enter FIRST CLIENT'S account's number for 'Withdraw'");
                                int tempAccount = scanner.nextInt();
                                System.out.println("Enter SECOND CLIENT'S account's number for 'Deposit'");
                                int tempAccountToTranfer = scanner.nextInt();
                                Account account = currentClientForTransferToAnotherClientFirst.getAccount(tempAccount); //search for first client's account by its number
                                Account accountToTransfer = currentClientForTransferToAnotherClientSecond.getAccount(tempAccountToTranfer); //search for second client's account by its number
                                if (account != null && accountToTransfer != null) {
                                    if (account.transfer(accountToTransfer, currentClientForTransferToAnotherClientFirst.getClass().getSimpleName()))
                                        System.out.println("     Successfully");
                                    else
                                        System.out.println("     NOT Successfully");
                                } else {
                                    System.err.println("No account found"); // making sure of correct value of client's account number, otherwise display error message
                                    break;
                                }
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 7:
                            System.out.println("Enter client's ID");
                            int clientIDForOperations = scanner.nextInt();
                            Client currentClientForOperations = bank.findClientByID(clientIDForOperations); //search for client for displaying operation list by client number
                            if (currentClientForOperations != null) {
                                System.out.println("Enter account's number for list of operations");
                                int tempAccount = scanner.nextInt();
                                Account account = currentClientForOperations.getAccount(tempAccount); //search for client's account by its number
                                if (account != null) {
                                    System.out.println(account.getOperations().toString());
                                } else {
                                    System.err.println("No account found"); // making sure of correct value of client's account number, otherwise display error message
                                    break;
                                }
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 8:
                            System.out.println("Enter client's ID");
                            int clientIDForListAcouunts = scanner.nextInt();
                            Client currentClientForListAcouunts = bank.findClientByID(clientIDForListAcouunts);//search for client by number for displaying his accounts
                            if (currentClientForListAcouunts != null) {
                                System.out.println(bank.getAccountsOfClientInfo(clientIDForListAcouunts));
                            } else {
                                System.err.println("No client found"); // making sure of correct value of client number, otherwise display error message
                                break;
                            }
                            break;
                        case 0:
                            break;
                        default: //in case of not appropriate command
                            System.err.println("Command is not correct");
                            break;
                    }
                    break;
                case 0:
                    command = 0;
                    break;
                default: //in case of not appropriate command
                    System.err.println("Command is not correct");
                    break;

            }
        }

    }
}
