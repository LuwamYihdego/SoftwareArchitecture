package stockcommandservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import stockcommandservice.model.Stock;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {
}
