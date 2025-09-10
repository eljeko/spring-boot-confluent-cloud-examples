package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@SpringBootApplication
public class KafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }
}

@Component
class KafkaMessageListener {

    // Inject topic name and group id from properties
    @Value("${consumer.topic.name}")
    private String topicName;

    @Value("${consumer.group.id}")
    private String groupId;

    // Listen to messages from "my-topic"
    @KafkaListener(topics = "${consumer.topic.name}", groupId = "${consumer.group.id}")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
