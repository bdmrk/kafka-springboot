package info.kausar.kafkaconsumer;

import info.kausar.kafkaconsumer.config.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class KafkaConsumerApplication {

    List<String> messageData = new ArrayList<>();
    User userFromTopics = null;

    @GetMapping("/getConsumedString")
    public List<String> consumeMsg() {
        return messageData;
    }

    @GetMapping("/getConsumedJson")
    public User consumeJsonMsg() {
        return userFromTopics;
    }

    @KafkaListener(groupId = "kausar-1", topics = "mrk", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data) {
        messageData.add(data);
        return messageData;
    }

    @KafkaListener(groupId = "kausar-2", topics = "mrk", containerFactory = "userKafkaListenerContainerFactory")
    public User getJsonFromTopic(User user) {
        userFromTopics = user;
        return userFromTopics;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

}
