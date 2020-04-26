package Thread.Chapter3.TwoThreadTransData;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class ThreadB extends Thread {
    private MyList list;
    public ThreadB(MyList list){
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
           while (true){
               if (list.size() == 5){
                   System.out.println("==5了,线程B要退出了！");
                   throw new InterruptedException();
               }
           }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
