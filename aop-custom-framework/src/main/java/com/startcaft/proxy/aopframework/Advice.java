package com.startcaft.proxy.aopframework;

import java.lang.reflect.Method;

/**
 * Created by startcaft on 2017/6/30.
 */
public interface Advice {

    void before(Method method);
    void after(Method method);
}
