package checkingaccount.service.impl;

import checkingaccount.model.Account;
import checkingaccount.repository.AccountRepository;
import checkingaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        restTemplate.put("http://localhost:8082/withdraw/{accountNumber}/{amount}", Account.class);
        accountRepository.save(account);
    }

    @Override
    public void withdraw(String accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber).get();
        account.withdraw(amount);
        restTemplate.put("http://localhost:8082/deposit/{accountNumber}/{amount}", Account.class);
        accountRepository.save(account);
    }
}
