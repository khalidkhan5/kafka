package com.kafka.p.c.controller;

import com.kafka.p.c.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class KafkaPCController {
    @Autowired
    MyService myService;

    @PostMapping("/producer")
    ResponseEntity<?> produce(){
        myService.sendMethod();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
