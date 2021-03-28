package info.kausar.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaApplication {

    @Autowired
    private KafkaTemplate<String, Object> template;
    private String topic = "mrk";

    @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable String name) {
        template.send(topic, "hello " + name + " Welcome to kafka");
        return "Data Published";
    }

    @GetMapping("/publishJson")
    public String publishMessage() {
        User user = new User(2232, "Kausar Rahman", new String[]{"Dhaka", "BTM", "Bangladesh"});
        template.send(topic, user);
        return "Json Data Published";
    }


    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

}
