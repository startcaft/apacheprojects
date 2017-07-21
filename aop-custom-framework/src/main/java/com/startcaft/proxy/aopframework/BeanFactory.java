package com.startcaft.proxy.aopframework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by startcaft on 2017/6/30.
 */
public class BeanFactory {

    Properties properties = new Properties();

    public BeanFactory(InputStream inputStream) {
        try{
            properties.load(inputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Object getBean(String classNamePropKey){
        String className = properties.getProperty(classNamePropKey);
        Object bean = null;
        try{
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }

        if (bean instanceof ProxyFactoryBean){
            ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) bean;

            Advice advice = null;
            Object target = null;

            try{
                //通过配置文件创建Advice的实例
                advice = (Advice) (Class.forName(properties.getProperty(classNamePropKey) + ".advice")).newInstance();

                //通过配置文件创建被代理对象的实例
                target = (Class.forName(properties.getProperty(classNamePropKey) + ".target")).newInstance();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            proxyFactoryBean.setAdvice(advice);
            proxyFactoryBean.setTarget(target);

            Object proxy = proxyFactoryBean.getProxy();
            return proxy;
        }

        return bean;
    }
}
