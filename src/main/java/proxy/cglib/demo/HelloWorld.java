package proxy.cglib.demo;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class HelloWorld {
    public String say(boolean say) throws Exception{
        System.out.println("Hello Student");
        if (!say){
            throw new Exception("回答错误！");
        }
        return "回答正确";
    }
}
