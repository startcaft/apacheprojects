package com.startcaft.activemq.spring;

import com.startcaft.activemq.spring.component.MQProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class MQProducerServiceTest {

    @Autowired
    private MQProducerService service;

    @Autowired
    private ActiveMQQueue destination;

    @Test
    public void testSendMsg(){
        {
            for (int i=0;i<10;i++){
                service.sendMessage(destination,"ActiveMQ整合Spring的消息发送：" + i);
            }
        }
    }
}
