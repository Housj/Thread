package Thread.yieldTest.sync;



/**
 * @author sergei
 * @create 2020-03-27
 */
public class Test {

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public synchronized static void test() {
        System.out.println("synchronized test");
        while (true){

        }
    }

    public synchronized static void test2(){
        System.out.println("static test2");
    }
}
