package aopdemo;

import java.lang.reflect.InvocationTargetException;

/**
 * @author sergei
 * @create 2020-02-17
 */
public interface Interceptor {
    boolean before();
    void after();
    //代理原有方法
    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
    void afterReturning();
    void afterThrowing();
    //是否使用around取代原有方法
    boolean useAround();
}
