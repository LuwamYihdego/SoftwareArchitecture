package productcommandservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import productcommandservice.service.impl.ProductEvent;

@Service
public class JmsSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(ProductEvent productEvent)  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String productEventString = objectMapper.writeValueAsString(productEvent);
            System.out.println("Sending a JMS message:" + productEventString);
            jmsTemplate.convertAndSend("productQueue", productEventString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
