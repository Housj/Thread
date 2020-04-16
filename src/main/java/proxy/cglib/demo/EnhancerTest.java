package proxy.cglib.demo;

/**
 * @author sergei
 * @create 2020-03-06
 */
public class EnhancerTest {

    public static void main(String[] args) throws Exception {
        HelloWorld hello = new HelloWorld();
        ProxyFactory proxy = new ProxyFactory();
        HelloWorld world = (HelloWorld) proxy.createProxy(hello);
        System.out.println(world.say(true));
    }
}
