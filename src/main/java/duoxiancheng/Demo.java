package duoxiancheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author sergei
 * @create 2020-03-21
 */
public class Demo {

    public static ArrayList<Integer> list = new ArrayList<>();
    public static AtomicInteger m2Count = new AtomicInteger(0);
    public static AtomicInteger m3Count = new AtomicInteger(0);
    public static CountDownLatch countDownLatch = new CountDownLatch(2);

  public static void main(String[] args) throws InterruptedException {
      HashMap n = new HashMap();
        Demo demo = new Demo();
        new Thread( ()->{
            demo.method1(Thread.currentThread());
        }).start();
        new Thread( ()->{
            demo.method1(Thread.currentThread());
        }).start();
        countDownLatch.await();
        System.out.println(m2Count.get());
//        System.out.println(m3Count.get());
        //System.out.println(list.get(0));
        System.out.println(list.size());
      for (int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i));
      }
    }

    public void method1(Thread thread){
        for (int i=0;i<500;i++){
            method2(thread);
//            method3(thread);
        }
        countDownLatch.countDown();
    }
    public void method2(Thread thread){
        list.add(m2Count.getAndIncrement());
//        System.out.println(thread+"method2 list.size()="+list.size());
//        m2Count.getAndIncrement();
    }
    public void method3(Thread thread){
        list.remove(0);
//        System.out.println(thread+"method3 list.size()="+list.size());
        m3Count.getAndIncrement();
    }
}
