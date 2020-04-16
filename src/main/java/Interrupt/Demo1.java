package Interrupt;

/**
 * @author sergei
 * @create 2020-03-11
 */
public class Demo1 extends Thread {
    volatile boolean stop = false;
    public static void main( String args[] ) throws Exception {
        Demo1 thread = new Demo1();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Asking thread to stop..." );
        thread.stop = true;//如果线程阻塞，将不会检查此变量
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println( "Stopping application..." );
        //System.exit( 0 );
    }

    public void run() {
        while ( !stop ) {
            System.out.println( "Thread running..." );
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
                System.out.println( "Thread interrupted..." );
            }
        }
        System.out.println( "Thread exiting under request..." );
    }
}
