package com.startcaft.activemq.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MQProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination,final String message){
        {
            System.out.println("生产者，发送了一条消息：" + message);
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(message);
                }
            });
        }
    }
}
