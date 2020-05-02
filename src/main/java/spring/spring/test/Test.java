package spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.bean.UserA;
import spring.bean.UserB;
import spring.conf.AppConfig;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoApplicationContext = new AnnotationConfigApplicationContext();
        annoApplicationContext.register(AppConfig.class);
        annoApplicationContext.refresh();


//        annoApplicationContext.getBean(UserA.class).say();

        UserA userA = (UserA)annoApplicationContext.getBean("userA");
        userA.say();

//        UserB userB = (UserB)annoApplicationContext.getBean("userAA");
//        userB.say();
    }
}
