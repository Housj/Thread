package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.Base;
import proxy.BaseImpl;
import java.lang.reflect.Method;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class CglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib CglibProxy begin");
                Object invoke = methodProxy.invoke(new BaseImpl(),objects);
                System.out.println("cglib CglibProxy end");
                return invoke;
            }
        });

        Base proxy = (Base) enhancer.create();
        proxy.add(1,4);
    }
}
