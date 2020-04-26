package Thread.aqs;


import java.util.HashMap;

/**
 * 利用juc包的lockSupport的park和unpark，锁住当前线程，让出CPU
 *
 * @author sergei
 * @create 2020-03-21
 */
public class Demo1 {

//    AbstractQueuedSynchronizer

    public static HashMap<Thread,Integer> ms = new HashMap<Thread,Integer>();

    public static void park() {
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName());
        Integer a = ms.get(t1);
        if (a != null && a > 0) {
            a -= 1;
            ms.put(t1, a);
        } else {
            a = -1;
            ms.put(t1, -1);
            while (a+1 != ms.get(t1)){}
        }
    }

    public static void unpark(Thread t1) {
        Integer a = ms.get(t1);
        if (a != null ) {
            ms.put(t1, a+1);
        } else {
            ms.put(t1, 1);
        }
    }

    public static void main(String[] args) {
        Thread main = Thread.currentThread();

        System.out.println("main--1");
        Thread t1 = new Thread(() ->{
            Demo1.park();
//            LockSupport.park();
            System.out.println("t1");
            try {
                Thread.sleep(10);
                System.out.println("t2");
//                Demo1.unpark(main);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
//        LockSupport.unpark(t1);
        Demo1.unpark(t1);
//        Demo1.park();
        System.out.println("main-2");

    }
}
