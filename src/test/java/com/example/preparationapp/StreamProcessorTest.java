package com.example.preparationapp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.Arrays;

@EmbeddedKafka(partitions = 1, topics = {"input-topic", "output-topic"})
@SpringBootTest(properties = {
        "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}",
        "spring.kafka.streams.application-id=test-application",
        "spring.kafka.streams.default-key-serde=org.apache.kafka.common.serialization.Serdes$StringSerde",
        "spring.kafka.streams.default-value-serde=org.apache.kafka.common.serialization.Serdes$StringSerde"
})

public class StreamProcessorTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        String[] beans = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }
        // Sprawdzenie podstawowe
        Assertions.assertTrue(applicationContext.containsBean("streamProcessor")); // <-- nazwa beana
    }

}