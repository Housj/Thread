package Chapter3.test2;


/**
 * @author sergei
 * @create 2019-11-29
 */
public class MyThread1 extends Thread {
    private Object lock;
    public MyThread1(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("开始wait");
                lock.wait();
                System.out.println("结束wait");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
