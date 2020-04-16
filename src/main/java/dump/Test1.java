package dump;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergei
 * @create 2020-04-07
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        List<String> lists = new ArrayList<>();
        for (int i=0;i<10000000;i++){
            lists.add(new String(i+""));
            Thread.sleep(1);
        }
    }
}
