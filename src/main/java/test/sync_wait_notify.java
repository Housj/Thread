package test;



/**
 * @author sergei
 * @create 2020-02-12
 */
public class sync_wait_notify {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Object o = new Object();
        char[] ac = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() ->{
            synchronized (o){
                if (!flag){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (char i:ac){
                    System.out.println(i);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t1").start();

        new Thread(() ->{
            synchronized (o){
                for (char i:aC){
                    System.out.println(i);
                    flag = true;
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        },"t2").start();
    }
}
