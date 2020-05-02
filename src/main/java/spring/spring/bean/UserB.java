package spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserB {

//    @Autowired
    UserA userA;

    UserB(UserA userA){
        this.userA = userA;
    }
    public void say(){
//        userA.say();
        System.out.println("UserB...");
    }

    UserB(){
        System.out.println("UserB init");
    }
}
