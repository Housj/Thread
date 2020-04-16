package Chapter3.wait_notify_size5;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadA extends Thread {
    private Object  lock;

    public ThreadA(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                if(MyList.size() != 5){
                    System.out.println("WAIT BEGIN");
                    lock.wait();
                    System.out.println("WAIT END");
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
