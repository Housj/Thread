package suanfa.likou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author sergei
 * @create 2020-04-20
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }
    public static boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));

    }
    private static CountDownLatch second = new CountDownLatch(1);

    public static boolean isAnagram(String s, String t) {

        if(s.length() == t.length()){
            char[] arra = s.toCharArray();
            char[] arrb = t.toCharArray();
            HashMap<Character,Integer> h = new HashMap();
            for(char c: arra){
                if (null != h.get(c)) {
                    h.put(c, Integer.parseInt(h.get(c).toString()) + 1);
                } else {
                    h.put(c, 1);
                }
            }

            for (char d : arrb){
                if(h.get(d)==null){
                    return false;
                }else{
                    h.put(d,Integer.parseInt(h.get(d).toString()) - 1);
                }
            }

            for(char c: arra){
                if(Integer.parseInt(h.get(c).toString())>0){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

}
