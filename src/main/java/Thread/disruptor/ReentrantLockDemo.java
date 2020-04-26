package Thread.disruptor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread th = new Thread(() ->{
            try {
                lock.lockInterruptibly();
                System.out.println("t2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });

        th.start();

        th.interrupt();
    }
}
