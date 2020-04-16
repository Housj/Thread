package Chapter3.wait_notify_size5;


/**
 * @author sergei
 * @create 2019-11-29
 */
public class Test {

    public static void main(String[] args) {
      try {
          Object lock = new Object();

          ThreadA a = new ThreadA(lock);
          a.start();

          Thread.sleep(50);

          ThreadB b = new ThreadB(lock);
          b.start();
      }catch (InterruptedException e){
          e.printStackTrace();
      }

    }
}
