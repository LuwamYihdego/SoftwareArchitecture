package shoppingcart.ShoppingCart.service;

import shoppingcart.ShoppingCart.dto.ProductDTO;
import shoppingcart.ShoppingCart.domain.Product;

public class ProductAdapter {

    public static Product getProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getProductNumber(),
                productDTO.getDescription(),
                productDTO.getPrice()
        );
        return product;
    }

    public static ProductDTO getProductDTO(shoppingcart.ShoppingCart.domain.Product product) {
        ProductDTO productDTO = new ProductDTO(
                product.getProductNumber(),
                product.getDescription(),
                product.getPrice()
        );
        return productDTO;
    }
}
