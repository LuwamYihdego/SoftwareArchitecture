package esb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class InternationalShippingActivator {

    @Autowired
    RestTemplate restTemplate;

    public void internationalShipping(Order order){
        System.out.println("International shipping: " + order.toString());
        restTemplate.postForLocation("http://localhost:8084/orders", order);
    }
}
