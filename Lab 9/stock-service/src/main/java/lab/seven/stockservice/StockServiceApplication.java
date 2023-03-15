package lab.seven.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController()
@RequestMapping("/stock")

public class StockServiceApplication {

	@GetMapping("product-number/{productNumber}")
	public int  numOfProducts(@PathVariable int productNumber){
		return  productNumber + 150 ;
	}


	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

}
