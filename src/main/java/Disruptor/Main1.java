package Disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class Main1 {

    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();
        int buffersize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory,buffersize, Executors.defaultThreadFactory());
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        long sequence = ringBuffer.next();

        try{
            LongEvent event = ringBuffer.get(sequence);
            event.set(8888L);
        }finally {
            ringBuffer.publish(sequence);
        }


    }
}
