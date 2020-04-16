package test;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sergei
 * @create 2020-02-11
 */
public class MyContainer<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try {
            lock.lock();
            while (lists.size() == MAX){
                producer.await();
            }
            lists.add(t);
            ++count;
            consumer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0){
                consumer.await();
            }
            t = lists.removeFirst();
            --count;
            producer.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer<String> c = new MyContainer<>();
        for (int i=0;i<10;i++){
            new Thread(() -> {
                for (int j=0;j<5;j++) System.out.println(c.get());
            },"c"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<2;i++){
            new Thread(() ->{
                for(int j=9;j<25;j++) c.put(Thread.currentThread().getName()+" "+j);
            },"p"+i).start();
        }
    }
}
