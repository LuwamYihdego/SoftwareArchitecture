package savingaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {
    @Id
    private String accountNumber;
    private String CustomerName;
    private Double balance;

    public void deposit(Double amount){
        this.balance += amount;
    }

    public void withdraw(Double amount){
        if(balance - amount < 0){
            return;
        } else {
            this.balance -= amount;
        }
    }
}

