package productcommandservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productcommandservice.model.Product;
import productcommandservice.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{productNumber}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productNumber, @RequestBody Product product){
        productService.updateProduct(productNumber, product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{productNumber}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String productNumber){
        productService.deleteProduct(productNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
