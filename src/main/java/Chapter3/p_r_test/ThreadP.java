package Chapter3.p_r_test;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadP extends Thread {

    private P p;

    public ThreadP(P p){
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
