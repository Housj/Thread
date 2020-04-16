package test2;

/**
 * @author sergei
 * @create 2020-04-01
 */
public class test3 {

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("A");
        StringBuilder b = new StringBuilder("B");
        add(a,b);
        System.out.println(a+","+b);
    }

    private static void add(StringBuilder a, StringBuilder b) {
        a.append(b);
        b = a;
    }
}
