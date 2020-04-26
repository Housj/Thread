package Thread.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
