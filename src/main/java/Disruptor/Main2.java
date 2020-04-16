package Disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class Main2 {

    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();
        int buffersize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory,buffersize, DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        EventTranslator<LongEvent> translator1 = new EventTranslator<LongEvent>() {
            @Override
            public void translateTo(LongEvent longEvent, long l) {
                longEvent.set(8887L);
            }
        };
        ringBuffer.publishEvent(translator1);

        EventTranslatorOneArg<LongEvent,Long> translator2 = new EventTranslatorOneArg<LongEvent, Long>() {
            @Override
            public void translateTo(LongEvent longEvent, long l, Long aLong) {
                longEvent.set(1);
            }
        };
        ringBuffer.publishEvent(translator2,7777L);

        EventTranslatorTwoArg<LongEvent,Long,Long> translator3 = new EventTranslatorTwoArg<LongEvent,Long,Long>(){
            @Override
            public void translateTo(LongEvent longEvent, long l, Long aLong, Long aLong2) {
                longEvent.set(1);
            }
        };
        ringBuffer.publishEvent(translator3,10000L,10000L);

        EventTranslatorThreeArg<LongEvent,Long,Long,Long> translator4 = new EventTranslatorThreeArg<LongEvent, Long, Long, Long>() {
            @Override
            public void translateTo(LongEvent longEvent, long l, Long aLong, Long aLong2, Long aLong3) {
                longEvent.set(aLong+aLong2+aLong3);
            }
        };
        ringBuffer.publishEvent(translator4,10000L,10000L,10000L);


//        EventTranslatorVararg<LongEvent> translator5 = new EventTranslatorThreeArg<LongEvent>(){
//            @Override
//            public void translateTo(Object o, long l, Object o2, Object o3, Object o4) {
//
//            }
//        };
//        ringBuffer.publishEvent(translator5,10000L,10000L,10000L,10000L);
    }
}
