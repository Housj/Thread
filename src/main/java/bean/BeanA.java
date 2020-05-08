package bean;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanA implements BeanNameAware, BeanFactoryAware, BeanPostProcessor, ApplicationContextAware, BeanFactoryPostProcessor {
    ApplicationContext applicationContext;
    BeanFactory beanFactory;
    String name;

    public void say(){
        System.out.println("Bean say");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("setBeanName ="+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("setBeanFactory ="+beanFactory);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean postProcessBeforeInitialization "+beanName);
        if (beanName.equals("bean")){
            System.out.println("bean postProcessBeforeInitialization");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean postProcessAfterInitialization "+beanName);
        if (beanName.equals("bean")){
            System.out.println("bean postProcessAfterInitialization");
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("setApplicationContext");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("bean");
//        beanDefinition.setInitMethodName("init");
    }

    @Pointcut
    @PostConstruct
    public void init(){
        System.out.println("init bean");
    }

    @PreDestroy
    public void destory(){
        System.out.println("destory bean");
    }
}
