package bean;

import org.springframework.context.annotation.*;

@Configuration
public class App {

    @Bean
    public BeanA bean(){
        return new BeanA();
    }
}
