package test3;
/**
 * 待构建的对象。该对象的特点：
 * <ol>
 * <li>需要用户手动的传入多个参数，并且有多个参数是可选的、顺序随意</li>
 * <li>该对象是不可变的（所谓不可变，就是指对象一旦创建完成，其内部状态不可变，
 更通俗的说是其成员变量不可改变）。 * 不可变对象本质上是线程安全的。</li>
 * <li>对象所属的类不是为了继承而设计的。</li>
 * </ol>
 * 满足上面特点的对象的构建可是使用下面的 Build 方式构建。这样构建对象有下面的好
 处：
 * <ol>
 * <li>不需要写多个构造函数，使得对象的创建更加便捷</li>
 * <li>创建对象的过程是线程安全的</li>
 * </ol>
 * @author xialei
 * @date 2015-5-2
 */
public class Person {
// 姓名（必填），final 修饰 name 一旦被初始化就不能再改变，保证了对象的不可变

    private final String name;
    // 年龄（必填）
    private final int age;
    // 身高（选填）
    private final int height;
    // 毕业学校（选填）
    private final String school;
    // 爱好（选填）
    private final String hobby;
    /**
     * 这个私有构造函数的作用：
     * <ol>
     * <li>成员变量的初始化。final 类型的变量必须进行初始化，否则无法编译成功</li>
     * <li>私有构造函数能够保证该对象无法从外部创建，并且 Person 类无法被继承</li>
     * </ol>
     */
    private Person(String name, int age, int height, String school, String hobby) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.school = school;
        this.hobby = hobby;
    }
    /**
     * 要执行的动作
     */
    public void doSomething() {
// TODO do what you want!!
    }
    /**
     * 构建器。为什么 Builder 是内部静态类？
     * <ol>
     * <li>必须是 Person 的内部类。否则，由于 Person 的构造函数私有，不能通过 new 的
     方式创建 Person 对象</li>
     * <li>必须是静态类。由于 Person 对象无法从外部创建，如果不是静态类，则外部无
     法引用 Builder 对象。</li>
     * </ol>
     * <b>注意</b>：Builder 内部成员变量要与 Person 的成员变量保持一致。
     * @author xialei
     *
     */
    public static class Builder {
        // 姓名（必填）。注意：这里不能是 final 的
        private String name;
        // 年龄（必填）
        private int age;
        // 身高（选填）
        private int height;
        // 毕业学校（选填）
        private String school;
        // 爱好（选填）
        private String hobby;
        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }
        public Builder setSchool(String school) {
            this.school = school;
            return this;
        }
        public Builder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }
        /**
         * 构建对象
         * @return 返回待构建的对象本身
         */
        public Person build() {
            return new Person(name, age, height, school, hobby);
        } } }