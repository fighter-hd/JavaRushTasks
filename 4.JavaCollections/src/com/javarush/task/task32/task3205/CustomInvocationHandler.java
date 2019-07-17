package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods targetObject;

    public CustomInvocationHandler(SomeInterfaceWithMethods targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");

        Object o = method.invoke(targetObject, args);

        System.out.println(method.getName() + " out");

        return o;
    }
}
