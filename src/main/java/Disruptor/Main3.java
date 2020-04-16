package Disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.io.IOException;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        LongEventFactory factory = new LongEventFactory();
        int buffersize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new,buffersize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith((event,sequnce,endOfBatch) -> System.out.println("Event:"+event));

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        ringBuffer.publishEvent((event,sequence)-> event.set(10000L));
        System.in.read();
    }
}
