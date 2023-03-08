package shoppingcart.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingcart.product.domain.Product;
import shoppingcart.product.dto.ProductDTO;
import shoppingcart.product.repository.ProductRepository;

import java.util.Optional;

@Component
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(ProductDTO productDTO){
        Product product= ProductAdapter.getProduct(productDTO);
        productRepository.save(product);
    }
    public ProductDTO getProductByNumber(String productNumber){
        Optional<Product> product=productRepository.findById(productNumber);
        if (product.isPresent()){
            return ProductAdapter.getProductDTO(product.get());
        }else
            return null;
    }
}
