package test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author sergei
 * @create 2020-02-12
 */
public class DelayQueueDemo {
    static BlockingQueue<MyTask> tasks = new DelayQueue();

    static class MyTask implements Delayed{
        String name;
        long runningTime;
        MyTask(String name,long runningTime){
            this.name = name;
            this.runningTime = runningTime;
        }

        @Override
        public String toString() {
            return name + " " +runningTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS)<o.getDelay(TimeUnit.MILLISECONDS)) return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS)>o.getDelay(TimeUnit.MILLISECONDS)) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask("t1",now+1000);
        MyTask t2 = new MyTask("t2",now+1500);
        MyTask t3 = new MyTask("t3",now+500);
        MyTask t4 = new MyTask("t4",now+1200);

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);

        System.out.println(tasks);

        for (int i=0;i<4;i++){
            System.out.println(tasks.take());
        }

    }
}
