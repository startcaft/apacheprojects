package com.startcaft.www;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ消息消费者
 */
public class JMSConsumer {

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

            System.out.println("默认ActiveMQ连接用户名:" + JMSConsumer.USERNAME);
            System.out.println("默认ActiveMQ连接密码:" + JMSConsumer.PASSWORD);
            System.out.println("默认ActiveMQ连接地址:" + JMSConsumer.BROKEURL);

            try {
                //实例化连接工厂对象
                factory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME,JMSConsumer.PASSWORD,JMSConsumer.BROKEURL);
                //通过连接工厂获取到连接对象，并启动
                connection = factory.createConnection();
                connection.start();
                //接收消息时创建的 Session 无需携带事务
                session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
                //构建一个消息来源，来自与 HelloWorld 的消息队列
                destination = session.createQueue("HelloWorld");
                //创建消息的消费者
                messageConsumer = session.createConsumer(destination);

                //无限循环的通过 receiver方法 来接收消息，效率比较低，不推荐这样做
                while (true){
                    //指定的间隔获取一次消息
                    TextMessage textMessage = (TextMessage) messageConsumer.receive(10000);
                    if (textMessage != null){
                        System.out.println("收到的ActiveMQ消息:" + textMessage.getText());
                    }
                    else {
                        break;
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                if (connection != null){
                    try {
                        connection.close();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
