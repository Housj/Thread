package suanfa.zifuchuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断字符串的括号是否正常，使用Map存储括号对，然后先匹配左括号，保存到Stack中，相同类型的括号肯定是挨着的，取到右括号判断是不是成对的括号
 *
 * @author sergei
 * @create 2020-04-30
 */
public class kuohao {

    private static final Map<Character,Character> brackets = new HashMap<>();

    static {
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');
    }

    public static void main(String[] args) {
        String str = "12312(3)";
        System.out.println(isMatch(str)?"true":"false");
    }

    private static boolean isMatch(String str) {
        if (str == null){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (brackets.containsValue(c)){
                stack.push(c);
            }else if (brackets.containsKey(c)){
                if (stack.empty() || stack.pop() != brackets.get(c)){
                    return false;
                }
            }
        }
        return true;
    }


}
