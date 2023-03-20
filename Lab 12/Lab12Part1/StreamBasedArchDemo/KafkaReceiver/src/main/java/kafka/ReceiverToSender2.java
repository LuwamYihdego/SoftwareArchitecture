package kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReceiverToSender2 {
    @KafkaListener(topics = {"topicA2"})
    public void receive(@Payload String message) {
        System.out.println("Receiver from sender2 received message= "+ message);
    }
}
