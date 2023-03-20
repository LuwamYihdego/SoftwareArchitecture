package productqueryservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import productqueryservice.service.ProductService;

@Service
public class StockEventListener {
    @Autowired
    private ProductService productService;

    @JmsListener(destination = "stockQueue")
    public void receiveMessage(final String stockEventString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            StockEvent stockEvent = objectMapper.readValue(stockEventString, StockEvent.class);
            System.out.println("JMS receiver received message:" + stockEventString);
            productService.updateStocks(stockEvent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
