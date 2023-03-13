package lab.seven.productservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="STOCK-SERVICE", url="localhost:8900/stock")
public interface ProductStock {

    @GetMapping("product-number/{productNumber}")
     int numOfProducts(@PathVariable int productNumber);
}
