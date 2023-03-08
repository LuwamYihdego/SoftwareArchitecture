package shoppingcart.ShoppingCart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingcart.ShoppingCart.domain.CartLine;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCartDTO {
    private String shoppingCartNumber;
    private ArrayList<CartLineDTO> cartLines;

    public void addCartLine(CartLineDTO cartLine) {
        cartLines.add(cartLine);
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "shoppingCartNumber='" + shoppingCartNumber + '\'' +
                ", cartLines=" + cartLines +
                '}';
    }
}
