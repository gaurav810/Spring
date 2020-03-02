package kafkapoc.kafkaconsumerpoc.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "name-topic", groupId = "test")
    public void consume(String message) {
        System.out.println(System.currentTimeMillis() + " ::::> Consumed message :::::> " + message);
	}
}
