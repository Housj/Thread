package Thread.Chapter3.wait_notify_size5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class MyList {
    private static List list = new ArrayList();

    public static void add(){
        list.add("a");
    }

    public static int size(){
        return list.size();
    }
}
