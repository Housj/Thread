package hash;

import java.util.LinkedHashMap;

/**
 * @author sergei
 * @create 2020-04-20
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(10, (float) 0.8,true);
        linkedHashMap.put("a",1);
        linkedHashMap.put("c",2);
        linkedHashMap.put("d",2);
        linkedHashMap.get("c");

        for (Object o : linkedHashMap.entrySet()) {
            System.out.println(o);
        }
    }
}
