package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClassHandler implements InvocationHandler {
    MyInterface myInterface = null;

    public ClassHandler(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("~~~~~before");
        Object temp = method.invoke(myInterface, args);
        System.out.println("~~~~~end");
        return temp;
    }
}
