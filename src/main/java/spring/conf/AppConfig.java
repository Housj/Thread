package  spring.conf;


import Thread.yieldTest.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import  spring.bean.UserA;

@ComponentScan("spring")
//@MapperScan("mapper")
public class AppConfig {

    @Bean(initMethod = "init")
    public UserA userA(){
      return new UserA();
    }
}
