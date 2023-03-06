package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {

		//create products
		restTemplate.postForLocation("http://localhost:8080/products", new ProductDTO("A33","TV",450.0));
		restTemplate.postForLocation("http://localhost:8080/products", new ProductDTO("A34","MP3 Player",75.0));

		//get a product and add to the shoppingcart
		ProductDTO product = restTemplate.getForObject("http://localhost:8080/products/A33", ProductDTO.class);
		restTemplate.postForLocation("http://localhost:8080/cart/1/3", product);
		//get a product and add to the shoppingcart
		product = restTemplate.getForObject("http://localhost:8080/products/A34", ProductDTO.class);
		restTemplate.postForLocation("http://localhost:8080/cart/1/2", product);

		//get the shoppingcart
		ShoppingCartDTO cart = restTemplate.getForObject("http://localhost:8080/cart/1", ShoppingCartDTO.class);
		System.out.println("\n-----Shoppingcart-------");
		if (cart != null) cart.print();

	}


}
