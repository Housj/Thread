package spring.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AopServiceImpl implements AopService  {
    @Override
    public String say() {
        System.out.println("AopServiceImpl-say");
        return "AopServiceImpl";
    }
}