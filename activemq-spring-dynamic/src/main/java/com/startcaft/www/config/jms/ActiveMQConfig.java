package com.startcaft.www.config.jms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "activeMQ")
public class ActiveMQConfig {

    private String brokerUrl;
    private String thisCode;
    private String jmsUsername;
    private String jmsPassword;
    private List<Queue> destination;
    private List<QueueListener> listeners;

    @XmlElement(name = "brokerUrl")
    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    @XmlElement(name = "thisCode")
    public String getThisCode() {
        return thisCode;
    }

    public void setThisCode(String thisCode) {
        this.thisCode = thisCode;
    }

    @XmlElementWrapper(name = "destinations")
    @XmlElement(name = "queue")
    public List<Queue> getDestination() {
        return destination;
    }

    public void setDestination(List<Queue> destination) {
        this.destination = destination;
    }

    @XmlElementWrapper(name = "listeners")
    @XmlElement(name = "queueListener")
    public List<QueueListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<QueueListener> listeners) {
        this.listeners = listeners;
    }

    @XmlElement(name = "jmsUsername")
    public String getJmsUsername() {
        return jmsUsername;
    }

    public void setJmsUsername(String jmsUsername) {
        this.jmsUsername = jmsUsername;
    }

    @XmlElement(name = "jmsPassword")
    public String getJmsPassword() {
        return jmsPassword;
    }

    public void setJmsPassword(String jmsPassword) {
        this.jmsPassword = jmsPassword;
    }

    @Override
    public String toString() {
        return "ActiveMQConfig{" +
                "brokerUrl='" + brokerUrl + '\'' +
                ", thisCode='" + thisCode + '\'' +
                ", jmsUsername='" + jmsUsername + '\'' +
                ", jmsPassword='" + jmsPassword + '\'' +
                ", destination=" + destination +
                ", listeners=" + listeners +
                '}';
    }
}
