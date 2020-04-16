package LockInterruptibly;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author sergei
 * @create 2020-03-11
 */
public class TestInterruptibly {



    @Test
    public void testInterruptibly() throws Exception{

        final BussinesClass bc = new BussinesClass();
        
        Thread t0=new Thread(){
            @Override
            public void run() {
                bc.bFuction();
            }
        };


        Thread t1=new Thread(){
            @Override
            public void run() {
                bc.bFuction();
            }
        };

        String tName=Thread.currentThread().getName();

        System.out.println(tName+"-启动t0！");
        t0.start();
        System.out.println(tName+"-我等个5秒，再启动t1");
        Thread.sleep(5000);
        System.out.println(tName+"-启动t1");
        t1.start();

        System.out.println(tName+"-t1获取不到锁，t0这货睡觉了，没释放，我等个5秒！");
        Thread.sleep(5000);
        System.out.println(tName+"-等了5秒了，不等了，把t1中断了！");
        t1.interrupt();

        Thread.sleep(Long.MAX_VALUE);
    }

}
