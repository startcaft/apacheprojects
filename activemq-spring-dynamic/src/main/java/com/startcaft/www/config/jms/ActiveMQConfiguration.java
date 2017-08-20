package com.startcaft.www.config.jms;

import com.startcaft.www.config.context.SpringManager;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMQConfiguration {

    private static final Logger LOGGER = Logger.getLogger(ActiveMQConfiguration.class);

    // ActiveMQ提供的真正的ConnectionFactory
    @Bean(name="jmsConnectionFactory")
    public ActiveMQConnectionFactory jmsConnectionFactory(){
        {
            ActiveMQConfig activeMQConfig = SpringManager.getMQConfig();
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            connectionFactory.setBrokerURL(activeMQConfig.getBrokerUrl());
            connectionFactory.setUserName(activeMQConfig.getJmsUsername());
            connectionFactory.setPassword(activeMQConfig.getJmsPassword());
            connectionFactory.setCloseTimeout(10*1000);
            connectionFactory.setSendTimeout(10*1000);
            return connectionFactory;
        }
    }

    // ActiveMQ提供一个PooledConnectionFactory，用于将Session，Connection和MessageProducer池化
    @Bean(name="pooledConnectionFactory")
    public PooledConnectionFactory pooledConnectionFactory(
            @Qualifier("jmsConnectionFactory") ActiveMQConnectionFactory jmsConnectionFactory){
        {
            PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
            pooledConnectionFactory.setConnectionFactory(jmsConnectionFactory);
            return pooledConnectionFactory;
        }
    }

    /** Spring提供的ConnectionFactory用来管理JMS厂商的ConnectionFactory **/
    @Bean(name="connectionFactory")
    public SingleConnectionFactory singleConnectionFactory(
            @Qualifier("pooledConnectionFactory") PooledConnectionFactory pooledConnectionFactory){
        {
            SingleConnectionFactory connectionFactory = new SingleConnectionFactory();
            connectionFactory.setTargetConnectionFactory(pooledConnectionFactory);
            connectionFactory.setReconnectOnException(true);//连接断开后重连
            return connectionFactory;
        }
    }

    /** Spring提供的JmsTemplate用来消费消息 **/
    @Bean
    public JmsTemplate jmsTemplate(
            @Qualifier("connectionFactory") SingleConnectionFactory connectionFactory){
        {
            JmsTemplate jmsTemplate = new JmsTemplate();
            jmsTemplate.setConnectionFactory(connectionFactory);
            return jmsTemplate;
        }
    }

    /*队列消息监听器*/
    @Bean
    public QueueMessageListener queueMessageListener(){
        {
            QueueMessageListener queueMessageListener = new QueueMessageListener();
            return queueMessageListener;
        }
    }
}
