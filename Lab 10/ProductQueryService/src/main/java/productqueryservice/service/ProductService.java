package productqueryservice.service;

import productqueryservice.model.Product;
import productqueryservice.service.impl.ProductEvent;
import productqueryservice.service.impl.StockEvent;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public Product updateProduct(String productNumber, Product product);
    public void deleteProduct(String productNumber);
    public Product getProduct(String productNumber);
    public List<Product> getAllProducts();
    void updateProducts(ProductEvent productEvent);
    void updateStocks(StockEvent stockEvent);

}
