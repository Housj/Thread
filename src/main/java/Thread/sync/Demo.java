package Thread.yieldTest.sync;


/**
 * @author sergei
 * @create 2020-03-27
 */
public class Demo {


    public static Test o = new Test();

    public static void main(String[] args) throws InterruptedException {


        new Thread(()->{new Test().test();}).start();
        new Thread(()->{Test.test2();}).start();

//        synchronized (o){
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
