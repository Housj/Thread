package j8;

public class Test {

    public static void main(String[] args) {
        test((String name)->{
            System.out.println(name);
        });
    }

    public static void test(Inter inter){
        inter.say("aa");
    }
}
