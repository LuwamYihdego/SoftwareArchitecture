package shoppingcart.ShoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shoppingcart.ShoppingCart.dto.ProductDTO;
import shoppingcart.ShoppingCart.dto.ShoppingCartDTO;
import shoppingcart.ShoppingCart.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
        @Autowired
        ShoppingCartService shoppingCartService;

        @PostMapping(value = "/{shoppingCartNumber}/{quantity}")
        public void addToShoppingCart(@PathVariable String shoppingCartNumber, @PathVariable Integer quantity, @RequestBody ProductDTO productDTO) {
            shoppingCartService.addToCartLine(shoppingCartNumber, productDTO, quantity);

        }

        @GetMapping("/{shoppingCartNumber}")
        public ShoppingCartDTO getShoppingCart(@PathVariable String shoppingCartNumber) {
            ShoppingCartDTO cart = shoppingCartService.getShoppingCart(shoppingCartNumber);

            System.out.println(cart);
            return cart;
        }

}
