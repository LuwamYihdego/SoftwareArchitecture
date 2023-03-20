package lab.seven.productservice;


import lab.seven.productservice.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@LoadBalancerClient(name="STOCK-SERVICE")
@RequestMapping("/products")
public class ProductServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceApplication.class);
	@Autowired
	private ProductStock productStock;

	List<Product> products = Arrays.asList(
			new Product(101,"Mac Book"),
			new Product(102,"Mac Air"),
					new Product(103,"Tablet"),
				new Product(104,"Iphone 14"),
				new Product(105,"DELE"),
			new Product(106,"HP")
	);
   @GetMapping("/product/{productNumber}")

	public Product getProduct(@PathVariable int productNumber){
		Product product = products.stream().filter(p -> p.getProductNumber() == productNumber).findFirst().orElse(null);
		System.out.println(product);
        product.setCountStock(productStock.numOfProducts(productNumber));
	log.info("Get product called");
		return product;
	}


public String getTextFallback(){
	return "Hello Histrix";
}


	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate template(){
	return new RestTemplate();
	}



}
