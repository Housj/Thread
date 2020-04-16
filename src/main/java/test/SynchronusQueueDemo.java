package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author sergei
 * @create 2020-02-12
 */
public class SynchronusQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() ->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aa");
        strs.put("bb");
        //strs.add("a");
        System.out.println(strs.size());
    }
}
