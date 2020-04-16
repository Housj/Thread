package extendsDemo;

/**
 * @author sergei
 * @create 2020-03-14
 */
class SubClass extends SuperClass
{
    public String name = "SubClass";
}

class SuperClass
{
    public String name = "SuperClass";
}

public class Demo
{
    public static void main(String[] args)
    {
        //取父类还是子类的属性值，不取决与创建对象时的类型，而是取决于定义的变量类型。
        SuperClass clz = new SubClass();
        //你觉得这里输出什么?
        System.out.println(clz.name);
    }
}