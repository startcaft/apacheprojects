package com.startcaft.www.config.jms;

import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * 队列消息监听器
 */
public class QueueMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            ActiveMQQueue queue = (ActiveMQQueue) message.getJMSDestination();
            System.out.println(queue.getQueueName());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
