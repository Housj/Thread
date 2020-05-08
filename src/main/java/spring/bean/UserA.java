package  spring.bean;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserA implements InitializingBean {

//    @Autowired
//    UserB userB;
//    UserA(UserB userB){
//        this.userB = userB;
//    }

    String name;

    public UserA(){
      System.out.println("构造函数 UserA init");
    }

    public void say(){
//        userB.say();
        System.out.println("UserA..."+name);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void init(){
        System.out.println("第三 initMethod...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第二 InitializingBean...");
    }


    @PostConstruct
    public void Pointcut(){
        System.out.println("第一 PostConstruct...");
    }
}
