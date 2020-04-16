package Disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public static long count = 0;

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        count++;
        System.out.println("["+Thread.currentThread().getName()+"]"+longEvent+"序号"+l);
    }
}
