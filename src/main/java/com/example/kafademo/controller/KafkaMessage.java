package com.example.kafademo.controller;

import com.example.kafademo.model.Order;
import com.example.kafademo.service.ConsumerService;
import com.example.kafademo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/rest/api")
public class KafkaMessage {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/producer")
    public void getMessageFromClient(@RequestParam("message") String message){
            producerService.sendToTopic(message);
    }

    @PostMapping("/producer/object")
    public ResponseEntity<?> getObjectFromClient(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        producerService.sendObjectToTopic(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Operation successful"));
    }
}
