package productqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ProductQueryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductQueryServiceApplication.class, args);
    }

}
