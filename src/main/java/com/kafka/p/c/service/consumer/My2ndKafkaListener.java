package com.kafka.p.c.service.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener( topics ={ "my-basic-producer-consumer","my-2-producer-consumer"},groupId = "consumer-group-b")
public class My2ndKafkaListener {
    @KafkaHandler
    public void consumeAllTopics(ConsumerRecord<String, String> record){
        //String topic = record.headers().lastHeader("topic").value().toString();
        try{
            String topic = "";
            System.out.println("The message consumed by group a: "+ record.value()+" Topic: "+topic);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
