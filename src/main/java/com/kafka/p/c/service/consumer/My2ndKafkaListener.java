package com.kafka.p.c.service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class My2ndKafkaListener {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener( topics = {"my-basic-producer-consumer", "my-2-producer-consumer"},groupId = "consumer-group-b")
    public void consumeAllTopics(ConsumerRecord<String, String> record){
        try{
            String topic = record.topic();
            String key = record.key();
            Map myObject = objectMapper.readValue(record.value(), Map.class);
            System.out.println("The message consumed by Group B: "+" Topic: "+topic+", key: "+key);

            for(Object o :myObject.keySet()){
                System.out.println(o+" : "+myObject.get(o));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
