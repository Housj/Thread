package j8;

//@FunctionalInterface
public interface Inter {

    default void say(String name){
        System.out.println(name);
    };


}
