package sync;


import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sergei
 * @create 2020-03-27
 */
public class Demo {


    public static Test o = new Test();

    public static void main(String[] args) {
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
