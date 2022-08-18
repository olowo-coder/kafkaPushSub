package com.example.kafademo.service;

import com.example.kafademo.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsumerService {

    @KafkaListener(topics = "paper_topic", groupId = "paper_group")
    @SendTo("glass_topic")
    public Order listenToTopic(String message){
        ObjectMapper mapper = new ObjectMapper();
        Order order = null;
        try {
            order = mapper.readValue(message, Order.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("received message -> " + message);
        return order;
    }

    @KafkaListener(topics = "glass_topic", groupId = "glass_group")
    public void listener(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = null;
        try {
            order = mapper.readValue(data, Order.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        order.setPrice(BigDecimal.valueOf(600.90));
        System.out.println("Second group: " + order);
    }
}
