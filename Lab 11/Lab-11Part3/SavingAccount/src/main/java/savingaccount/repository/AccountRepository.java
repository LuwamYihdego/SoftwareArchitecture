package savingaccount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import savingaccount.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
}