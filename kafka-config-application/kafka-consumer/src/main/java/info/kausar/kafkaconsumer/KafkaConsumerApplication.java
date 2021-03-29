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
    User userFromTopic = null;


    @GetMapping("/getConsumedString")
    public List<String> consumeMsg() {
        return messageData;
    }


    @GetMapping("/consumeJsonMessage")
    public User consumeJsonMessage() {
        return userFromTopic;
    }

    @KafkaListener(groupId = "kausar", topics = "mrk", containerFactory = "kafkaListenerContainerFactory")
    public List<String> getMsgFromTopic(String data) {
        messageData.add(data);
        return messageData;
    }


    @KafkaListener(groupId = "kausar2", topics = "mrk", containerFactory = "userKafkaListenerContainerFactory")
    public User getJsonMsgFromTopic(User user) {
        userFromTopic = user;
        return userFromTopic;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

}
