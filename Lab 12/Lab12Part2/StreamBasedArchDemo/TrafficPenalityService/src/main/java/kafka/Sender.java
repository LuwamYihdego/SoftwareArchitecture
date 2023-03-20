package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, FeeRecord> kafkaTemplate;

    @Value("${app.topic.ownertopic}")
    private String topic;

    public void send(FeeRecord feeRecord){
        kafkaTemplate.send(topic, feeRecord);
    }
}
