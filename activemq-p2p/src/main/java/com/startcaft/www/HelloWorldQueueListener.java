package com.startcaft.www;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 自定义消息监听器
 */
public class HelloWorldQueueListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        {
            try {
                System.out.println("监听器收到的消息："+((TextMessage)message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
