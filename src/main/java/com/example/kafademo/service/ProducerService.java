package com.example.kafademo.service;

import com.example.kafademo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    KafkaTemplate<String, Order> kafkaTemplate;

    public void sendToTopic(String message){
//        kafkaTemplate.send("paper_topic", message);
    }

    public void sendObjectToTopic(Order order) {
        kafkaTemplate.send("paper_topic", order);
    }
}
