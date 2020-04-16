package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sergei
 * @create 2020-02-13
 */
public class single_thread_pool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i=0;i<5;i++){
            final int j = i;
            service.execute(() ->{
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
    }
}
