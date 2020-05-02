package ThrowableTest;

public class TestFinally {

    public static void main(String[] args) {
        try{
            System.out.println("try");
            System.out.println(1/0);
            System.out.println("try2");
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("F");
            System.out.println(1/0);
            System.out.println("F2");
        }
    }
}
//OutOfMemoryError
//StackOverflowError
//        ClassCastException
//ClassNotFoundException
//                NullPointerException
//IndexOutOfBoundsException
//                        ArrayStoreException
//BufferOverflowException
//