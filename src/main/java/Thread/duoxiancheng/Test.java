package Thread.duoxiancheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sergei
 * @create 2020-04-10
 */
public class Test {

    public static void main(String[] args) {

        Object o = new Object();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
//                synchronized (o){
                    list.add(finalI);
//                }
                System.out.println(list);
            }).start();
        }

    }
}
