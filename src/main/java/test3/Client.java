package test3;

//客户端构建对象的方式见下面的代码：
/**
 * 使用 Person 对象的客户端
 * @author xialei
 * @date 2015-5-2
 */
public class Client {
    public static void main(String[] args) {
        /*
         * 通过链式调用的方式创建 Person 对象，非常优雅！
         */
        Person person = new Person.Builder("james", 12)
                .setHeight(170)
                .setHobby("reading")
                .build();
        person.doSomething();
    } }
