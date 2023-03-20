package productcommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ProductCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCommandServiceApplication.class, args);
    }

}
