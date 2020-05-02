package spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserA {

//    @Autowired
//    UserB userB;
//    UserA(UserB userB){
//        this.userB = userB;
//    }

    String name;

    UserA(){
      System.out.println("UserA init");
    }

    public void say(){
//        userB.say();
        System.out.println("UserA..."+name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
