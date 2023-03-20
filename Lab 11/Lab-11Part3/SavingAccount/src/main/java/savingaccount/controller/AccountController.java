package savingaccount.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import savingaccount.model.Account;
import savingaccount.service.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        accountService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public ResponseEntity<Account> deposit(@PathVariable String accountNumber, @PathVariable Double amount){
        Account account = accountService.getAccount(accountNumber);
        account.deposit(amount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public ResponseEntity<Account> withdraw(@PathVariable String accountNumber, @PathVariable Double amount){
        Account account = accountService.getAccount(accountNumber);
        account.withdraw(amount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
