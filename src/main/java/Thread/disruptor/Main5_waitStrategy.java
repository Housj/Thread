package Thread.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.*;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class Main5_waitStrategy {
    public static void main(String[] args) throws InterruptedException {
        LongEventFactory factory = new LongEventFactory();
        int buffersize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory,buffersize,
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                new SleepingWaitStrategy());
        disruptor.handleEventsWith(new LongEventHandler(),new LongEventHandler());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        final int threadCount = 50;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        ExecutorService service = Executors.newCachedThreadPool();
        for (long i=0;i<threadCount;i++){
            final long threadNum = i;
            service.submit(() ->{
                System.out.println("Thread %s ready to start!\n"+threadNum);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                for (int j=0;j<100;j++){
                    ringBuffer.publishEvent((event,sequence) ->{
                        event.set(threadNum);
                        System.out.println("生产了"+threadNum);
                });
                }
            });
        }

        service.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(LongEventHandler.count);
    }
}
