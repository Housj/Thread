package Thread.Chapter3.TwoThreadTransData;

import java.util.ArrayList;

/**
 * @author sergei
 * @create 2019-11-29
 */
public class MyList {
    volatile private ArrayList list = new ArrayList();
    public void add(){
        list.add("高安市");
    }

    public int size(){
        return list.size();
    }
}
