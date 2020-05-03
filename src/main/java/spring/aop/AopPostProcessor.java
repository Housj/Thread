package spring.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//@Component
public class AopPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("aopServiceImpl")){
//            Object o = Proxy.newProxyInstance(AopPostProcessor.class.getClassLoader(),bean.getClass().getInterfaces(), new AopInvocationHandler(bean));
            Object o = Proxy.newProxyInstance(AopPostProcessor.class.getClassLoader(),bean.getClass().getInterfaces(), new InvocationHandler(){

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("aop start");
                    Object s = method.invoke(bean,args);
                    System.out.println("aop end");
                    return s;
                }
            });
            return o;
        }
        return null;
    }
}
