package com.startcaft.www;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ消息消费者，使用 MessageListener 来接收消息
 * 使用 MessageListener 消息监听器唯一的要求就是 Connection 对象不能被关闭
 */
public class JMSConsumer2 {

    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        {
            ConnectionFactory factory = null;// 连接工厂
            Connection connection = null;// 连接
            Destination destination = null;// 接收消息时的消息来源
            Session session = null;// 会话 用于创建生产者，消费者，消息等
            MessageConsumer messageConsumer = null;// 消息的消费者

            System.out.println("默认ActiveMQ连接用户名:" + JMSConsumer2.USERNAME);
            System.out.println("默认ActiveMQ连接密码:" + JMSConsumer2.PASSWORD);
            System.out.println("默认ActiveMQ连接地址:" + JMSConsumer2.BROKEURL);

            try {
                //实例化连接工厂对象
                factory = new ActiveMQConnectionFactory(JMSConsumer2.USERNAME, JMSConsumer2.PASSWORD, JMSConsumer2.BROKEURL);
                //通过连接工厂获取到连接对象，并启动
                connection = factory.createConnection();
                connection.start();
                //接收消息时创建的 Session 无需携带事务
                session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
                //构建一个消息来源，来自与 HelloWorld 的消息队列
                destination = session.createQueue("HelloWorld");
                //创建消息的消费者
                messageConsumer = session.createConsumer(destination);
                //设置消息监听器
                messageConsumer.setMessageListener(new HelloWorldQueueListener());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
