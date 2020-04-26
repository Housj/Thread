package Thread.duoxiancheng;

/**
 * @author sergei
 * @create 2020-03-22
 */
public class Demo1 {
    private class a{

    }

    public static void main(String[] args) {

//        Thread t = new Thread(()->{
//            Demo1.test(Thread.currentThread());
//        });
//        t.start();
//        Thread t1 = new Thread(()->{
//            Demo1.test(Thread.currentThread());
//        });
//        t1.start();


    }
    public static Object o = new Object();

    public static void test(Thread thread){
        synchronized (o){
            while (true){
                System.out.println(thread+"=="+1);
            }
        }
    }
}
