package com.startcaft.www.config.context;

import com.startcaft.www.config.jms.ActiveMQConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class SpringManager implements ApplicationListener<ContextRefreshedEvent> {

    private static ApplicationContext applicationContext = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(applicationContext == null){
            applicationContext = event.getApplicationContext();
        }
    }
    /*ApplicationContext context= ContextLoader.getCurrentWebApplicationContext();//尝试下这个方法*/
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static ActiveMQConfig getMQConfig(){
        {
            ActiveMQConfig activeMQConfig = null;
            try {
                File file = ResourceUtils.getFile("classpath:activemq.xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(ActiveMQConfig.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                activeMQConfig = (ActiveMQConfig) jaxbUnmarshaller.unmarshal(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return activeMQConfig;
        }
    }
}
