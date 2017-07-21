package com.startcaft.proxy.aopframework;

import java.lang.reflect.Proxy;

public class ProxyFactoryBean {

    private Object target;
    private Advice advice;

    public Object getProxy(){
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), (proxyObj,method,paramArr) -> {
                    this.advice.before(method);//前置调用
                    Object returnVal = method.invoke(this.target,paramArr);
                    this.advice.after(method);//后置调用
                    return returnVal;
                });

        return proxy;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
