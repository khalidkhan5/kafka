package com.kafka.p.c.service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendKafkaMessage(String topic,String message){
        kafkaTemplate.send(topic,message);
        System.out.println("Message sent to kafka topic: "+topic);
    }
}
