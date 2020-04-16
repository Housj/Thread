package aopdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sergei
 * @create 2020-02-17
 */
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Object proceed() throws InvocationTargetException,IllegalAccessException{
        return method.invoke(target,params);
    }

    public Invocation(Object target,Method method,Object[] params){
        this.target = target;
        this.params = params;
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
