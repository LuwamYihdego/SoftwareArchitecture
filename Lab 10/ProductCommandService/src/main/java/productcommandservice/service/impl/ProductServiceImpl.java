package productcommandservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productcommandservice.integration.JmsSender;
import productcommandservice.model.Product;
import productcommandservice.repository.ProductRepository;
import productcommandservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private JmsSender jmsSender;

    @Override
    public Product addProduct(Product product) {

        productRepository.save(product);
        jmsSender.sendMessage(new ProductEvent("Add product", product));
        return product;
    }

    @Override
    public Product updateProduct(String productNumber, Product product) {

        productRepository.save(product);
        jmsSender.sendMessage(new ProductEvent("Update product", product));
        return product;
    }

    @Override
    public void deleteProduct(String productNumber) {
        Product product = productRepository.findById(productNumber).get();
        jmsSender.sendMessage(new ProductEvent("Delete product", product));
        productRepository.deleteById(productNumber);
    }
}
