package proxy;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class BaseImpl implements Base {
    public int add(int a, int b) {
        System.out.println("BaseImpl");
        return a+b;
    }
}
