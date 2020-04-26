package Thread.Chapter3.p_r_test;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadC extends Thread {

    private C c;

    public ThreadC(C c){
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.getValue();
        }
    }
}
