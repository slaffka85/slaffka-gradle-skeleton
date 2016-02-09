package com.slaffka;

/*
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
*/

//import com.slaffka.controller.HelloController;
//import com.slaffka.EntityController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;
//import org.springframework.context.annotation.Import;

/*import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.annotation.EnableJms;*/

@ComponentScan("com.slaffka")
@EnableJms
@EnableScheduling
@EnableAutoConfiguration
@PropertySource({"classpath:${region:default}.properties" })
public class ApplicationConfig extends SpringBootServletInitializer {

    // Strictly speaking this bean is not necessary as boot creates a default
    @Bean
    JmsListenerContainerFactory<?> topicJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    // Strictly speaking this bean is not necessary as boot creates a default
    @Bean
    JmsListenerContainerFactory<?> queueJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    public static void main(String[] args) {
        //EntityController entityController = new EntityController();
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfig.class, args);
        //HelloController helloController = new HelloController();
        // Send a message
/*        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");

        jmsTemplate.send("emailQueue", messageCreator);*/
    }
}
