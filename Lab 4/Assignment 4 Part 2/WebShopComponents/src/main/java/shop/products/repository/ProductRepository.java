package shop.products.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import shop.products.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
