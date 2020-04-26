package Thread.Chapter3.test2;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class MyThread2 extends Thread{
    private Object lock;

    public MyThread2(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("notify开始");
            lock.notify();
            System.out.println("notify结束");
        }
    }
}
