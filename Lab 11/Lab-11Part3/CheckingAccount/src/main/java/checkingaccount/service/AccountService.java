package checkingaccount.service;

import checkingaccount.model.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccount(String accountNumber);
    public void deposit(String accountNumber, Double amount);
    public void withdraw(String accountNumber, Double amount);
}
