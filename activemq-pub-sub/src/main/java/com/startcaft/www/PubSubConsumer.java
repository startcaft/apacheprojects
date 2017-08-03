package com.startcaft.www;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Pub/Sub 发布订阅下的消息消费者
 * 必须是消费者先订阅，然后再发布信息
 */
public class PubSubConsumer {

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

            System.out.println("默认ActiveMQ连接用户名:" + PubSubConsumer.USERNAME);
            System.out.println("默认ActiveMQ连接密码:" + PubSubConsumer.PASSWORD);
            System.out.println("默认ActiveMQ连接地址:" + PubSubConsumer.BROKEURL);

            try {
                //实例化连接工厂对象
                factory = new ActiveMQConnectionFactory(PubSubConsumer.USERNAME, PubSubConsumer.PASSWORD, PubSubConsumer.BROKEURL);
                //通过连接工厂获取到连接对象，并启动
                connection = factory.createConnection();
                connection.start();
                //接收消息时创建的 Session 无需携带事务
                session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
                //创建一个名为 HelloWorldTopic 的主题
                destination = session.createTopic("HelloWorldTopic");
                //创建消息的消费者
                messageConsumer = session.createConsumer(destination);
                //设置消息监听器
                messageConsumer.setMessageListener(new TopicListener1());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
