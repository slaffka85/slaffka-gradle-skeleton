package com.slaffka.reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by slaffka85 on 07.02.2016.
 */
@Component
public class CallReciever {
    /*    @Autowired
    ConfigurableApplicationContext context;*/

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "callQueue", containerFactory = "queueJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        //context.close();
        //FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }


    @JmsListener(destination = "callTopic", containerFactory = "topicJmsContainerFactory")
    public void subscribeMessage(String message) {
        System.out.println("subscribeMessage <" + message + ">");
        //context.close();
        //FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
