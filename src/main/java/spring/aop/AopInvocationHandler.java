package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler {
    Object o;
    public AopInvocationHandler(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("aop start");
        Object s = method.invoke(o,args);
        System.out.println("aop end");
        return s;
    }
}
