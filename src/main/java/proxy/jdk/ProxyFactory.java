package proxy.jdk;

import proxy.Base;
import proxy.BaseImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class ProxyFactory implements InvocationHandler {
    private Class<?> target;
    private Object real;
    public ProxyFactory(Class<?> target){
        this.target = target;
    }
    public Object bind(Object real){
        this.real = real;
        return  Proxy.newProxyInstance(target.getClassLoader(),new Class[]{target},this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk ProxyFactory start");
        Object invoke = method.invoke(real,args);
        System.out.println("jdk ProxyFactory end");
        return invoke;
    }

    public static void main(String[] args) {
        Base proxy = (Base)new ProxyFactory(Base.class).bind(new BaseImpl());
        proxy.add(1,2);
    }
}
