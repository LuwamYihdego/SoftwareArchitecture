package shoppingcart.ShoppingCart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shoppingcart.ShoppingCart.domain.Product;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartLineDTO {
    private Integer quantity;

    private ProductDTO productDTO;
}
