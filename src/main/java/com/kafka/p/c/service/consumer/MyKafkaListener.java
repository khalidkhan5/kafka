package com.kafka.p.c.service.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener( topics = "my-basic-producer-consumer", groupId = "consumer-group-id")
public class MyKafkaListener {
    @KafkaHandler
    public void handleStringMessage(String message){
        System.out.println("This is the message produced by producer: "+ message);
    }
//    @KafkaHandler
//    public void handleObjectMessage(Object message){
//        System.out.println("Handle string message: "+ message);
//    }

}
