package  spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import  spring.aop.AopService;
import  spring.bean.*;
import  spring.conf.AppConfig;

public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annoApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        annoApplicationContext.register(AppConfig.class);
//        annoApplicationContext.refresh();

//         AopService aopService = (AopService) annoApplicationContext.getBean("myFactoryBean");
//         System.out.println(aopService.say());

//        annoApplicationContext.getBean(UserA.class).say();

//        UserA userA = (UserA)annoApplicationContext.getBean("userA");
//        userA.say();

//        UserB userB = (UserB)annoApplicationContext.getBean("userAA");
//        userB.say();

//          annoApplicationContext.getBean(UserC.class).say();

        annoApplicationContext.getBean("userD",UserD.class).say();
        annoApplicationContext.getBean("userE",UserE.class).say();
    }
}
