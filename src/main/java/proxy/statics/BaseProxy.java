package proxy.statics;

import proxy.Base;
import proxy.BaseImpl;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class BaseProxy implements Base {

    private Base base;
    public BaseProxy(Base base){
        this.base = base;
    }

    public int add(int a, int b) {
        System.out.println("static BaseProxy start");
        int result = base.add(a,b);
        System.out.println("static BaseProxy end");
        return result;
    }

    public static void main(String[] args) {
        Base base = new BaseImpl();
        new BaseProxy(base).add(1,3);
    }
}
