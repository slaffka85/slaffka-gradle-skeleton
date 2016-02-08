package com.slaffka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@RestController
@RequestMapping("/jms")
public class JmsTestController {

    @Autowired
    private JmsTemplate jmsTemplate;


    @RequestMapping("/")
    public String home() {
        // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };
        System.out.println("Sending a new message.");

        jmsTemplate.send("queue/emailQueue", messageCreator);
        jmsTemplate.send("callTopic", messageCreator);
        return "Hello world from Spring Boot";
    }
}
