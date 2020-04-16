package Chapter3.pipedInputOutput;

import java.io.PipedInputStream;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadRead extends Thread {

    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read,PipedInputStream input){
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
