package Thread.Interrupt;

/**
 * @author sergei
 * @create 2020-03-11
 */
public class Demo extends Thread {
    boolean stop=false;
    public static void main( String args[] ) throws Exception {
        Demo thread = new Demo();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Interrupting thread..." );
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println("Stopping application..." );
    }
    public void run() {
        while(!stop){
            System.out.println( "Thread is running..." );
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)) {
            }
        }
        System.out.println("Thread exiting under request..." );
    }
}
