package Thread.duoxiancheng;

import java.util.concurrent.CountDownLatch;

/**
 * @author sergei
 * @create 2020-03-24
 */
public class Demo2 {
    public static int a=0;
    public static CountDownLatch cd = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for (int i=0;i<100;i++){
                add();
            }

        }).start();
        new Thread(()->{
            for (int i=0;i<100;i++){
                add();
            }
        }).start();

        cd.countDown();

        Thread.sleep(1000);
        System.out.println(a);
    }

    public static void add() {
            boolean is = false;
            for (int i=1;i<=2;++i){
                if (i%2==1) is = true;
                else is = false;
                a +=i*(is?1:-1);
            }

    }
}
