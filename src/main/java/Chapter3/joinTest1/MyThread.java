package Chapter3.joinTest1;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int)(Math.random()*1000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
