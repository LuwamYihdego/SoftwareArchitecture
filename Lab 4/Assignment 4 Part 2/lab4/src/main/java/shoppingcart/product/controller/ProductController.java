package shoppingcart.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shoppingcart.product.dto.ProductDTO;
import shoppingcart.product.service.ProductService;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping(value = "add")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    @GetMapping(value = "{productNumber}")
    public ProductDTO getProductByProductNumber(@PathVariable String productNumber){
       return productService.getProductByNumber(productNumber);
    }

}
