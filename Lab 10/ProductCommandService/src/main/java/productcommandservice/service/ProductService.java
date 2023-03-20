package productcommandservice.service;

import productcommandservice.model.Product;

public interface ProductService {
    public Product addProduct(Product product);
    public Product updateProduct(String productNumber, Product product);
    public void deleteProduct(String productNumber);

}
