package  spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import  spring.aop.AopPostProcessor;
import  spring.aop.AopService;
import  spring.aop.AopServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new UserC();
//        AopService as = (AopService)Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(),new Class[]{AopServiceImpl.class.getInterfaces()[0]}, new InvocationHandler(){
//
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("MyFactoryBean aop start");
//                Object s = method.invoke(new AopServiceImpl(),args);
//                System.out.println("MyFactoryBean aop end");
//                return s;
//            }
//        });
//        return as;
    }

    @Override
    public Class<?> getObjectType() {
        return UserC.class;
    }
}
