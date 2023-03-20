package productcommandservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import productcommandservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
