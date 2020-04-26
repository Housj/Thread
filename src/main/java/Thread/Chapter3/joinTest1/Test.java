package Thread.Chapter3.joinTest1;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class Test {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            thread.join();
 
            System.out.println("thread对象执行完毕后再执行");
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
