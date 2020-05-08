package bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.bean.UserD;
import spring.bean.UserE;
import spring.conf.AppConfig;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoApplicationContext = new AnnotationConfigApplicationContext(BeanA.class);

        annoApplicationContext.getBean(BeanA.class).say();

        annoApplicationContext.close();


//        System.out.println( 9 + (9 >> 1));
    }
}
