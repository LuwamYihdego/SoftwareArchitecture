package lab.seven.productservice;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="STOCK-SERVICE", path = "/product-stock/api")
public interface ProductStock {

    @GetMapping("product-number/{productNumber}")
     int numOfProducts(@PathVariable int productNumber);
}
