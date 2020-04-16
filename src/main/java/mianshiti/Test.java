package mianshiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sergei
 * @create 2020-04-04
 */
public class Test {

    public static void main(String[] args) {
        int i = 1;
        i = i++;
//        System.out.println(i);
//        int j = i++;
//        System.out.println(j);
//        int k = i + ++i * i++;
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(k);
//        ArrayList<int> a = new ArrayList()<int>;
        ArrayList<Integer> a = new ArrayList<Integer>();

//        Hashtable b = new Hashtable();
//        b.put(null,"a");
//        b.put(null,"b");
//        System.out.println(b.get(0));

        HashMap m = new HashMap();
        m.put(null,"a");
        m.put(null,"b");
        m.put(null,null);
        System.out.println(m.containsKey(null));
        System.out.println(m.get(null));

        ConcurrentHashMap cm = new ConcurrentHashMap();
        cm.put("1","a1");
        cm.put("2","s2");
        System.out.println(cm.containsKey(null));
        System.out.println(cm.get(null));

    }
}
