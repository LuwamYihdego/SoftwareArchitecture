package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    OwnerService ownerService;


    @KafkaListener(topics = "tofasttopic")
    public void receive(@Payload SpeedRecord speedRecord, // from payLoad he will take speed record
                        @Headers MessageHeaders headers) {
        System.out.println("*** find owner of "+ speedRecord.toString());
        ownerService.findOwner(speedRecord.licencePlate, speedRecord.getSpeed());
    }
}