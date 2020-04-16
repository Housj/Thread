package test2;

/**
 * @author sergei
 * @create 2020-04-04
 */
public class T implements Runnable {

    private  /*volatile*/ int count = 100;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {

        T t = new T();
        for (int i = 0; i < 100; i++) {
            new Thread(t, "THREAD" + i).start();
        }

//        ThreadLocal a = new ThreadLocal();
//        a.set("a");
//        System.out.println(a.get());
//
//        ThreadLocal b = new ThreadLocal();
//        b.set("b");
//        System.out.println(b.get());
//
//        ThreadLocal c = new ThreadLocal();
//        c.set("c");
//        System.out.println(c.get());
//
//        b.remove();
//        System.out.println(c.get());

    }
}