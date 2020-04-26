package Thread.Chapter3.p_r_test;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class Run {

    public static void main(String[] args) {
        String lock = new String("");

        P p = new P(lock);
        C c = new C(lock);

        ThreadP p1 = new ThreadP(p);
        ThreadC c1 = new ThreadC(c);

        p1.start();
        c1.start();
    }
}
