package Chapter3.TwoThreadTransData;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class Test {

    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

    }
}
