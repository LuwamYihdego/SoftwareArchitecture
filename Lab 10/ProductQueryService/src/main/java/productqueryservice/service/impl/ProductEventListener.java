package productqueryservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import productqueryservice.service.ProductService;

@Service
public class ProductEventListener {
    @Autowired
    private ProductService productService;

    @JmsListener(destination = "productQueue")
    public void receiveMessage(final String productEventString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductEvent productEvent = objectMapper.readValue(productEventString, ProductEvent.class);
            System.out.println("JMS receiver received message:" + productEventString); //
            productService.updateProducts(productEvent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
