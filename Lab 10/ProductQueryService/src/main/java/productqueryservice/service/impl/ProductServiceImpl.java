package productqueryservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productqueryservice.model.Product;
import productqueryservice.repository.ProductRepository;
import productqueryservice.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String productNumber, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String productNumber) {
        productRepository.deleteById(productNumber);
    }

    @Override
    public Product getProduct(String productNumber) {
        return productRepository.findById(productNumber).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProducts(ProductEvent productEvent) {
        if (productEvent.getEvent().equals("Add product")){
            addProduct(productEvent.getProduct());
        } else if (productEvent.getEvent().equals("Delete product")){
            deleteProduct(productEvent.getProduct().getProductNumber());
        }
        else if (productEvent.getEvent().equals("Update product")){
            updateProduct(productEvent.getProduct().getProductNumber(), new Product(productEvent.getProduct().getProductNumber(),
                    productEvent.getProduct().getName(), productEvent.getProduct().getPrice(), productEvent.getProduct().getNumberInStock()));
        }
    }

    @Override
    public void updateStocks(StockEvent stockEvent) {
        Optional<Product> optionalProduct = productRepository.findById(stockEvent.getProductNumber());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setNumberInStock(stockEvent.getQuantity());
            System.out.println("Updating stock: "+product.getProductNumber()+" , quantity = "+stockEvent.getQuantity());
            productRepository.save(product);
        }

    }
}
