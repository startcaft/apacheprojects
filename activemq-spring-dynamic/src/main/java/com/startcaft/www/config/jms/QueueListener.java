package com.startcaft.www.config.jms;

import javax.xml.bind.annotation.XmlAttribute;

public class QueueListener {

    private String code;
    private String remark;

    @XmlAttribute(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlAttribute(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "QueueListener{" +
                "code='" + code + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
