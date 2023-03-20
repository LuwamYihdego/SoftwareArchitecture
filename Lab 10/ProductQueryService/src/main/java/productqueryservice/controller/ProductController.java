package productqueryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productqueryservice.model.Product;
import productqueryservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/productsInStock")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable String productNumber){
        Product product = productService.getProduct(productNumber);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
