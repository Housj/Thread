package Chapter3.pipedInputOutput;

import java.io.PipedOutputStream;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadWrite extends Thread {

    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write,PipedOutputStream out){
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
