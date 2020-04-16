package test;


import java.util.concurrent.locks.LockSupport;

/**
 * @author sergei
 * @create 2020-02-12
 */
public class lock_support {

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {

        char[] ac = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(() ->{
                for (char i:ac){
                    System.out.println(i);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
        });

        t2 = new Thread(() -> {
            for (char i : aC) {
                LockSupport.park();
                System.out.println(i);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
