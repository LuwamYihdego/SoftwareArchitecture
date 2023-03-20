package savingaccount.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import savingaccount.model.Account;
import savingaccount.repository.AccountRepository;
import savingaccount.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountRepository.findById(accountNumber).get();
    }

    @Override
    public void deposit(String accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber).get();
        account.deposit(amount);
        restTemplate.put("http://localhost:8081/withdraw/{accountNumber}/{amount}", Account.class);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(String accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber).get();
        account.withdraw(amount);
        restTemplate.put("http://localhost:8081/deposit/{accountNumber}/{amount}", Account.class);
        accountRepository.save(account);
    }
}

