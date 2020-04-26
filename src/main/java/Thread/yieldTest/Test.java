package Thread.yieldTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author sergei
 * @create 2020-04-02
 */
public class Test  {

    public static void main(String[] args) throws Exception {

        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" start...");
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+" end...");
            }).start();
        }

        new Thread(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        })).start();
    }

    public void a(){
        System.out.println("test");
    }
}
