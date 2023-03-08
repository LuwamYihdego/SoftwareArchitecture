package shoppingcart.ShoppingCart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import shoppingcart.ShoppingCart.domain.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String> {
}
