package Chapter3.wait_notify_size5;



/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadB extends Thread {
    private Object  lock;

    public ThreadB(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
              for (int i=0;i<10;i++){
                  MyList.add();
                  if (MyList.size()==5){
                      lock.notify();
                      System.out.println("发出通知");
                  }
                  System.out.println("添加了"+(i+1));
                  Thread.sleep(1000);
              }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
