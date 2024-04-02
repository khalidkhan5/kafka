package com.kafka.p.c.controller;

import com.kafka.p.c.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/v1")
public class KafkaPCController {
    @Autowired
    MyService myService;

    @PostMapping("/producer")
    ResponseEntity<?> produce(@RequestHeader String topic, @RequestHeader String key, @RequestBody Map data){
        myService.sendMethod(topic, key, data);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
