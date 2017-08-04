package com.startcaft.activemq.spring.config;

import com.startcaft.activemq.spring.listeners.HelloWorldQueueMessageListener;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

/**
 * ActiveMQ配置
 * 1，配置Spring提供的ConnectionFactory
 * 2，配置消息生产者 JmsTemplate
 * 3，配置Destination
 * 4，配置消息消费者 MessageListenerContainer
 *
 * 依赖于 spring-jms jar包
 */
@Configuration
public class ActiveMQConfig {

    // ActiveMQ提供的真正的ConnectionFactory
    @Bean(name="targetConnectionFactory")
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        {

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
            connectionFactory.setBrokerURL("tcp://localhost:61616");// 默认是无需用户名和密码的
            return connectionFactory;
        }
    }

    // ActiveMQ提供一个PooledConnectionFactory，用于将Session，Connection和MessageProducer池化
    @Bean(name="pooledConnectionFactory")
    public PooledConnectionFactory pooledConnectionFactory(
                                        @Qualifier("targetConnectionFactory") ActiveMQConnectionFactory targetConnectionFactory){
        {
            PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
            pooledConnectionFactory.setConnectionFactory(targetConnectionFactory);
            return pooledConnectionFactory;
        }
    }

    /** Spring提供的ConnectionFactory用来管理JMS厂商的ConnectionFactory **/
    @Bean(name="connectionFactory")
    public SingleConnectionFactory singleConnectionFactory(
                                        @Qualifier("pooledConnectionFactory") PooledConnectionFactory targetConnectionFactory){
        {
            SingleConnectionFactory connectionFactory = new SingleConnectionFactory();
            connectionFactory.setTargetConnectionFactory(targetConnectionFactory);
            return connectionFactory;
        }
    }

    // ActiveMQQueue 名为<HelloWorld>的destination
    @Bean(name="HelloWorldQueueDestination")
    public ActiveMQQueue activeMQQueue(){
        {
            ActiveMQQueue queue = new ActiveMQQueue("HelloWorld");
            return queue;
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

    // 自定义的MessageListener消息监听器
    @Bean
    public HelloWorldQueueMessageListener helloWorldQueueMessageListener(){
        {
            HelloWorldQueueMessageListener messageListener = new HelloWorldQueueMessageListener();
            return messageListener;
        }
    }

    /** Spring提供的MessageListenerContainer 负责接收消息并分发到MessageListener **/
    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer(
                                    @Autowired HelloWorldQueueMessageListener hwqListener,
                                    @Qualifier("HelloWorldQueueDestination") ActiveMQQueue destination,
                                    @Qualifier("connectionFactory") SingleConnectionFactory connectionFactory){
        {
            DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
            defaultMessageListenerContainer.setMessageListener(hwqListener);
            defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
            defaultMessageListenerContainer.setDestination(destination);
            return defaultMessageListenerContainer;
        }
    }
}
