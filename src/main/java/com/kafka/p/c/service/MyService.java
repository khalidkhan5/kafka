package com.kafka.p.c.service;

import com.kafka.p.c.service.producer.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MyService {
    @Autowired
    KafkaMessageProducer kafkaMessageProducer;
    public void sendMethod(){
        for(int i=0;i<100;i++){
            kafkaMessageProducer.sendKafkaMessage("my-basic-producer-consumer","Count: "+i);
        }
    }
}
