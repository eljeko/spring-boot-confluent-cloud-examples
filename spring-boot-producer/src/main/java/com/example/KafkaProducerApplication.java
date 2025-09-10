package com.example;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Locale;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerApplication {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Faker faker;

    @Value("${producer.interval.seconds:10}")
    private int intervalSeconds;

    @Value("${producer.topic.name:default-topic}")
    private String topicName;

    public KafkaProducerApplication(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.faker = new Faker(new Locale("en"));
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Scheduled(fixedDelayString = "${producer.interval.seconds:10}000")
    public void produceUserInfo() {
        String userInfo = String.format(
            "User[name=%s, email=%s, city=%s]",
            faker.name().fullName(),
            faker.internet().emailAddress(),
            faker.address().city()
        );

        kafkaTemplate.send(topicName, userInfo)
            .thenAccept(result -> System.out.println("Sent to " + topicName + ": " + userInfo))
            .exceptionally(ex -> {
                System.err.println("Failed to send message: " + ex.getMessage());
                return null;
            });
    }
}
