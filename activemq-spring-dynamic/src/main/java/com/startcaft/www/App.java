package com.startcaft.www;

import com.startcaft.www.config.context.SpringManager;
import com.startcaft.www.config.jms.ActiveMQConfig;
import com.startcaft.www.config.jms.Queue;
import com.startcaft.www.config.jms.QueueMessageListener;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.util.ResourceUtils;

import javax.jms.JMSException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);

        dynamicLoad();
    }

    public static void dynamicLoad(){

        ActiveMQConfig activeMQConfig = SpringManager.getMQConfig();
        ApplicationContext applicationContext = SpringManager.getApplicationContext();
        SingleConnectionFactory singleConnectionFactory = (SingleConnectionFactory) applicationContext.getBean("connectionFactory");

        //beanfactory
        DefaultListableBeanFactory beanFactory =
                (DefaultListableBeanFactory) SpringManager
                        .getApplicationContext()
                        .getAutowireCapableBeanFactory();

        //通过BeanDefinitionBuilder创建Bean的定义
        //注册队列
        if (activeMQConfig.getDestination() != null){
            activeMQConfig.getDestination().forEach((q) -> {
                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                        .genericBeanDefinition(ActiveMQQueue.class);
                beanDefinitionBuilder.addConstructorArgValue(q.getName());
                beanFactory.registerBeanDefinition(q.getCode(),beanDefinitionBuilder.getRawBeanDefinition());
            });
        }

        //注册队列监听容器
        if (activeMQConfig.getListeners() != null){
            activeMQConfig.getListeners().forEach((l) -> {
                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                        .genericBeanDefinition(DefaultMessageListenerContainer.class);
                beanDefinitionBuilder.addPropertyValue("connectionFactory",singleConnectionFactory);
                //queue destinaTION
                ActiveMQQueue queue = beanFactory.getBean(l.getCode(),ActiveMQQueue.class);
                beanDefinitionBuilder.addPropertyValue("destination", queue);
                //messagerlistener
                QueueMessageListener messageListener = beanFactory.getBean(QueueMessageListener.class);
                beanDefinitionBuilder.addPropertyValue("messageListener",messageListener);

                beanFactory.registerBeanDefinition(l.getCode() + ".Container",beanDefinitionBuilder.getRawBeanDefinition());
            });
        }

        activeMQConfig.getDestination().forEach((q) -> {
            {
                ActiveMQQueue queue = (ActiveMQQueue) applicationContext.getBean(q.getCode());
                try {
                    System.out.println(queue.getQueueName());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
