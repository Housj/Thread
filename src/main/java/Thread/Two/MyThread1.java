package Thread.Two;


/**
 * @author sergei
 * @create 2019-11-25
 */
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread");
    }
}

public class MyThread1{
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }
}
