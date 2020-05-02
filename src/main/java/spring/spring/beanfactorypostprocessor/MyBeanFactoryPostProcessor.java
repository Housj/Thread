package spring.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import spring.bean.UserB;

@Component
//工厂挂钩，允许自定义修改应用程序上下文bean定义，以适应上下文基础bean工厂的bean属性值
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 在标准初始化之后，修改应用程序上下文的内部bean工厂。所有bean定义都将被加载，但是还没有实例化bean 这甚至可以覆盖或添加属性，甚至可以用于初始化bean。
     * @param beanFactory 应用程序上下文使用的bean工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userA");
        beanDefinition.setLazyInit(true);
//        beanDefinition.setBeanClassName("UserAA"); 这个设置不成功？
        System.out.println("MyBeanFactoryPostProcessor - postProcessBeanFactory");



//        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("userA");
//        genericBeanDefinition.setBeanClass(UserB.class);
//        genericBeanDefinition.setBeanClassName("userAA");

    }
}
