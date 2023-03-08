package shoppingcart.product.service;

import shoppingcart.product.domain.Product;
import shoppingcart.product.dto.ProductDTO;

public class ProductAdapter {

    public static Product getProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getProductNumber(),
                productDTO.getDescription(),
                productDTO.getPrice()
        );
        return product;
    }

    public static ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO(
                product.getProductNumber(),
                product.getDescription(),
                product.getPrice()
        );
        return productDTO;
    }


}
