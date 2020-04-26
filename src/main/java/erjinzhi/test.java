package erjinzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergei
 * @create 2020-03-30
 */
public class test {
//    static Logger log = LoggerFactory.getLogger(test.class);

//    public static void main(String[] args) {
//        log.info("mesg");
//    }
    public static void main(String[] args) {
        List<String> s = new ArrayList<>();

        int n = 3;
        int a = 3-1;
        System.out.println(a>>>1);
        a |= a>>>1;
        a |= a>>>2;
        a |= a>>>4;
        a |= a>>>8;
        a |= a>>>16;
        a = (a < 0) ? 1 : (a >= 100) ? 100 : a + 1;
        System.out.println(a);

//        HashMap a = new HashMap(4);
//        a.put("a",a.size());
//        a.put("B",a.size());
//        a.put("C",a.size());
//        a.put("A",a.size());
//        System.out.println(a.size());
    }
}

