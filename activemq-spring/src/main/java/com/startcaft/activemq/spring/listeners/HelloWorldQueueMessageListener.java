package com.startcaft.activemq.spring.listeners;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 针对 HelloWorld消息队列的消息监听器
 */
public class HelloWorldQueueMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("HelloWorldQueueMessageListener收到的消息："+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
