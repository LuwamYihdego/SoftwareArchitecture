package shoppingcart.ShoppingCart.service;

import shoppingcart.ShoppingCart.domain.CartLine;
import shoppingcart.ShoppingCart.domain.ShoppingCart;
import shoppingcart.ShoppingCart.dto.CartLineDTO;
import shoppingcart.ShoppingCart.dto.ShoppingCartDTO;

public class ShoppingCartAddapter {


    public static ShoppingCart getShoppingCart(ShoppingCartDTO shoppingCartDTO){

        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setShoppingCartNumber(shoppingCartDTO.getShoppingCartNumber());

        for(CartLineDTO cartLine : shoppingCartDTO.getCartLines()){
            shoppingCart.addToShoppingCart(ProductAdapter.getProduct(cartLine.getProductDTO()),cartLine.getQuantity());
        }
        return shoppingCart;

    }
    public static ShoppingCartDTO getShoppingCartDTO(ShoppingCart shoppingCart) {
    ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setShoppingCartNumber(shoppingCart.getShoppingCartNumber());
		for (CartLine cartLine : shoppingCart.getCartLines()) {
        CartLineDTO cartLineDTO = new CartLineDTO();
        cartLineDTO.setQuantity(cartLine.getQuantity());
        cartLineDTO.setProductDTO(ProductAdapter.getProductDTO(cartLine.getProduct()));
        shoppingCartDTO.addCartLine(cartLineDTO);
    }
		return shoppingCartDTO;
}
}
