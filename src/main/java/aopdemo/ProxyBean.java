package aopdemo;

import Chapter3.p_r_test.P;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sergei
 * @create 2020-02-17
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;
    private Interceptor interceptor = null;

    public static Object getProxyBean(Object target,Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        Object object = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxyBean);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(proxy,method,args);
        Object returnObj = null;
        try {
            if (this.interceptor.before()){
                returnObj = this.interceptor.around(invocation);
            }else {
                returnObj = method.invoke(target,args);
            }
        }catch (Exception e){
            exceptionFlag = true;
        }

        this.interceptor.after();
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
        }
        return null;
    }
}
