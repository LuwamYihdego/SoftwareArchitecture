package shoppingcart.ShoppingCart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingcart.ShoppingCart.domain.Product;
import shoppingcart.ShoppingCart.domain.ShoppingCart;
import shoppingcart.ShoppingCart.dto.ProductDTO;
import shoppingcart.ShoppingCart.dto.ShoppingCartDTO;
import shoppingcart.ShoppingCart.repository.ShoppingCartRepository;

import java.util.Optional;

@Service
public class ShoppingCartService {
        @Autowired
    ShoppingCartRepository shoppingCartRepository;


    public void addToCartLine(String shoppingCartNumber, ProductDTO productDto, int quantity) {
        Product product = new Product(productDto.getProductNumber(),productDto.getDescription(),productDto.getPrice());
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(shoppingCartNumber);
        if (cart.isPresent() && product != null) {
            ShoppingCart shoppingCart = cart.get();
            shoppingCart.addToShoppingCart(product, quantity);
            shoppingCartRepository.save(shoppingCart);
        }
        else if (product != null) {
            ShoppingCart carts = new ShoppingCart();
            carts.setShoppingCartNumber(shoppingCartNumber);
            carts.addToShoppingCart(product, quantity);
            shoppingCartRepository.save(carts);
        }
    }

    public ShoppingCartDTO getShoppingCart(String cartId) {
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(cartId);
        if (cart.isPresent())
            return ShoppingCartAddapter.getShoppingCartDTO(cart.get());
        else
            return null;
    }


}
