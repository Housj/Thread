package test2;


import java.lang.reflect.Field;

/**
 * @author sergei
 * @create 2020-04-06
 */
public class Test5 {

    static Integer a = 2;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {
        System.out.println(a);
        exchang(a);
        System.out.println(a);

//        Thread.sleep(10000000);
    }

    private static void exchang(Integer a) throws NoSuchFieldException, IllegalAccessException {
        Field f = Test5.class.getDeclaredField("a");
        f.setAccessible(true);
        f.set(a,502);
    }


}
