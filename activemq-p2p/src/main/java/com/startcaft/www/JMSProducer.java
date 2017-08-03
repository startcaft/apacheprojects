package com.startcaft.www;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * ActiveMQ 消息生产者
 */
public class JMSProducer {

    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //发送的消息数量
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        {
            ConnectionFactory factory = null;// 连接工厂
            Connection connection = null;// 连接
            Destination destination = null;// 消息发送的目的地
            Session session = null;// 会话 用于创建生产者，消费者，消息等
            MessageProducer messageProducer = null;// 消息生产者

            System.out.println("默认ActiveMQ连接用户名:" + JMSProducer.USERNAME);
            System.out.println("默认ActiveMQ连接密码:" + JMSProducer.PASSWORD);
            System.out.println("默认ActiveMQ连接地址:" + JMSProducer.BROKEURL);

            try {
                //实例化连接工厂对象
                factory = new ActiveMQConnectionFactory(JMSProducer.USERNAME,JMSProducer.PASSWORD,JMSProducer.BROKEURL);
                //通过连接工厂获取到连接对象，并启动
                connection = factory.createConnection();
                connection.start();
                //创建session，一般来说发送消息都会包括在一个session事务中，并且设置消息的应答方式，一般选择自动应答。
                session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
                //创建一个名为 HelloWorld的消息队列
                destination = session.createQueue("HelloWorld");
                //创建消息生产者
                messageProducer = session.createProducer(destination);
                //发送消息
                JMSProducer.sendMessage(session,messageProducer);
                // 带事务的session一定要提交才会发送消息
                session.commit();;
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                //关闭连接对象，严格意义上都需要关闭，但是连接比较消耗服务器资源
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

    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception {
        {
            for (int i=0;i<SENDNUM;i++){
                // 创建文本消息
                TextMessage textMessage = session.createTextMessage("ActiveMQ发送消息:" + i);
                // 通过生产者发送消息
                messageProducer.send(textMessage);

                System.out.println("已发送消息：ActiveMQ发送消息" + i);
            }
        }
    }
}
