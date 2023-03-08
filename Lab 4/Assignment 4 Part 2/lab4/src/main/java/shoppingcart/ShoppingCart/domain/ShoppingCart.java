package shoppingcart.ShoppingCart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Iterator;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class ShoppingCart {
    @Id
    private String shoppingCartNumber;
    private ArrayList<CartLine> cartLines;

    public void addToShoppingCart(Product product,Integer quantity){
        for(CartLine cartLine: cartLines){
            if(cartLine.getProduct().getProductNumber().equals(product.getProductNumber())){
            cartLine.setQuantity(cartLine.getQuantity()+quantity);
            return;
            }
        }
        CartLine newCartLine=new CartLine();
            newCartLine.setProduct(product);
            newCartLine.setQuantity(quantity);
            cartLines.add(newCartLine);
    }

    public void removeFromCart(Product product){
        Iterator<CartLine> iterateCartLine = cartLines.iterator();
        while (iterateCartLine.hasNext()){
            CartLine cartLine = iterateCartLine.next();
            if (cartLine.getProduct().getProductNumber().equals(product.getProductNumber())){
                if (cartLine.getQuantity()>1){
                    cartLine.setQuantity(cartLine.getQuantity()-1);
                }
                else{
                    iterateCartLine.remove();
                     }
            }
        }
    }
}

