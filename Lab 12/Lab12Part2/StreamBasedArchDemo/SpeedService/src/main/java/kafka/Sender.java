package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, SpeedRecord> kafkaTemplate;

    @Value("${app.topic.tofasttopic}")
    private String topic;

    public void send(SpeedRecord speedRecord){
        kafkaTemplate.send(topic, speedRecord);
    }
}
