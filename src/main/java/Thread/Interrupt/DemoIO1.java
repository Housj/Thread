package Thread.Interrupt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sergei
 * @create 2020-03-11
 */
public class DemoIO1 extends Thread {
    volatile boolean stop = false;
    volatile ServerSocket socket;
    public static void main( String args[] ) throws Exception {
        DemoIO1 thread = new DemoIO1();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Asking thread to stop..." );
        thread.stop = true;
        thread.socket.close();
        Thread.sleep( 3000 );
        System.out.println( "Stopping application..." );
        //System.exit( 0 );
    }
    public void run() {
        try {
            socket = new ServerSocket(7856);
        } catch ( IOException e ) {
            System.out.println( "Could not create the socket..." );
            return;
        }
        while ( !stop ) {
            System.out.println( "Waiting for connection..." );
            try {
                Socket sock = socket.accept();
            } catch ( IOException e ) {
                System.out.println( "accept() failed or interrupted..." );
            }
        }
        System.out.println( "Thread exiting under request..." );
    }
}
