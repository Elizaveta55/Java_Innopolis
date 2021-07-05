package BankSystem.Account;

//all basic operations of all account's types
// present interface unit of operations with money, therefore I principle is not violated
public interface IAccountOperations {
    void deposit(double money);
    boolean withdraw(double money);
    void transfer(Account account, double money);
}
