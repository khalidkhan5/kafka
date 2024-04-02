package com.kafka.p.c.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {
    @KafkaListener( topics = {"my-basic-producer-consumer", "my-2-producer-consumer"}, groupId = "consumer-group-a")
    public void consumeAllTopics(ConsumerRecord<String,String> record){
        try{
            String topic = record.topic().toString();
            System.out.println("The message consumed by group a: "+ record.value()+" Topic: "+topic);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
