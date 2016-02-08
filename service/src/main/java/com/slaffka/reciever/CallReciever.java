package com.slaffka.reciever;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slaffka.domain.Notify;
import com.slaffka.repository.NotifyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by slaffka85 on 07.02.2016.
 */
@Component
public class CallReciever {

    private static Logger logger = LoggerFactory.getLogger(CallReciever.class);

    @Autowired
    private NotifyRepository notifyRepository;

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "outgoingCallQueue", containerFactory = "queueJmsContainerFactory")
    public void receiveMessage(String message) throws IOException {
        logger.debug("outgoingCallQueue, message = " + message);

        ObjectMapper objectMapper = new ObjectMapper();
        Notify notify = objectMapper.readValue(message, Notify.class);

        notifyRepository.save(notify);
    }


    @JmsListener(destination = "callTopic", containerFactory = "topicJmsContainerFactory")
    public void subscribeMessage(String message) {
        System.out.println("subscribeMessage <" + message + ">");
        //context.close();
        //FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
