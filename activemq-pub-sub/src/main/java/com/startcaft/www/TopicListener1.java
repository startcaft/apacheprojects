package com.startcaft.www;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Topic的订阅者1
 */
public class TopicListener1 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        {
            try {
                System.out.println("订阅者一收到的消息："+((TextMessage)message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
