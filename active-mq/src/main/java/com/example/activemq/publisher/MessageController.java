package com.example.activemq.publisher;

import com.example.activemq.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessage systemMessage){

        jmsTemplate.convertAndSend("my-queue",systemMessage);

        return new ResponseEntity<>("Sent!", HttpStatus.OK);
    }
}
