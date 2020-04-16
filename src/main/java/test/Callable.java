package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author sergei
 * @create 2020-02-25
 */
public class Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future f = es.submit(new work());
        System.out.println(f.get());
        es.shutdown();
    }

    static class work implements java.util.concurrent.Callable{


        @Override
        public Object call() throws Exception {
            return "aaa";
        }
    }
}
