package suanfa.digui;

/**
 * @author sergei
 * @create 2020-03-15
 */
public class huiwenzi {

    public static boolean isPalindromeString_recursive(String s){
        System.out.println("s="+s);
        int start = 0;
        int end = s.length()-1;
        if (end > start){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            else {
                return isPalindromeString_recursive(s.substring(start+1,end));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeString_recursive("78987"));
    }
}
