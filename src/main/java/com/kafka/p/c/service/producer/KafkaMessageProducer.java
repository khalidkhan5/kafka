package com.kafka.p.c.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class KafkaMessageProducer {
    private final ObjectMapper objectMapper= new ObjectMapper();
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendKafkaMessage(String topic, String key, Map data) {
        try {
            String jsonData = objectMapper.writeValueAsString(data);
            kafkaTemplate.send(topic, key, jsonData);
            System.out.println("Message sent to kafka topic: " + topic);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
