package Thread.disruptor;

/**
 * @author sergei
 * @create 2020-02-14
 */
public class LongEvent {

    private long value;

    public void set(long value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "LongEvent{"+"value="+value+"}";
    }
}
