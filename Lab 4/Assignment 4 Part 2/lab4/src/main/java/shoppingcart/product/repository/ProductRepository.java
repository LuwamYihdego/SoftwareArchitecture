package shoppingcart.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shoppingcart.product.domain.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
