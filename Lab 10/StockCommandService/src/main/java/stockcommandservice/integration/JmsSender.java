package stockcommandservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import stockcommandservice.service.impl.StockEvent;

@Service
public class JmsSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(StockEvent stockEvent)  {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String stockEventString = objectMapper.writeValueAsString(stockEvent);
            System.out.println("Sending a JMS message:" + stockEventString);
            jmsTemplate.convertAndSend("stockQueue", stockEventString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
