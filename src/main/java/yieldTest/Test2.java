package yieldTest;


/**
 * @author sergei
 * @create 2020-04-02
 */
public class Test2 extends Test {

    public static void main(String[] args) throws Exception {
        User u1 =  new User("a","b");
//        User u2 =  new User("a1","b");
//        new Test2().b(u1);
//        new Test2().b(u1);
//        new Test2().b(u1);
//        new Test2().b(u1);
//        new Test2().b(u2);
//        Object o = new Object();
//        new Test2().b(o);

        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    new Test2().b(u1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Test2 t = new Test2();
//        for (int i=0;i<10;i++){
//            new Thread(()->{
//                try {
//                    t.b2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }

    }

    public synchronized void b2() throws InterruptedException {
        System.out.println("begin");
            System.out.println("进入");
            Thread.sleep(2000);
        System.out.println("end");
    }

    public void b(Object o) throws InterruptedException {
//        System.out.println("begin");
        synchronized (o){
            System.out.println("进入");
            Thread.sleep(2000);
        }
        System.out.println("end");
    }
}

