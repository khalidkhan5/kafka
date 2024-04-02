package com.kafka.p.c.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class My2ndKafkaListener {
    @KafkaListener( topics = {"my-basic-producer-consumer", "my-2-producer-consumer"},groupId = "consumer-group-b")
    public void consumeAllTopics(ConsumerRecord<String, String> record){
        try{
            String topic = record.topic().toString();
            System.out.println("The message consumed by group b: "+ record.value()+" Topic: "+topic);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
