package com.kafka.p.c.service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

@Component
public class MyKafkaListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener( topics = {"my-basic-producer-consumer", "my-2-producer-consumer"}, groupId = "consumer-group-a")
    @Retryable(value = RuntimeException.class ,maxAttempts = 3, maxAttemptsExpression = "#{environment.getProperty('my.app.maxRetries')}")
    public void consumeAllTopics(ConsumerRecord<String,String> record) throws RuntimeException{
            String topic = record.topic();
            String key = record.key();
            boolean flag=true;
            System.out.println("trying");
            if(flag) {
                throw new RuntimeException("failed");
            }
            Map myObject ;
            try{
                myObject = objectMapper.readValue(record.value(), Map.class);
                System.out.println("The message consumed by Group A: "+" Topic: "+topic+", key: "+key);

                for(Object o :myObject.keySet()){
                    System.out.println(o+" : "+myObject.get(o));
                }
            } catch (Exception e){
                System.out.println("mapping issue");
            }


    }

}
