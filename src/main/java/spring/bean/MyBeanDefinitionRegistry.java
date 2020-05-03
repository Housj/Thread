package spring.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanDefinitionRegistry implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition();
//        AbstractBeanDefinition beanDefinition = bdb.getBeanDefinition();
//        beanDefinition.setBeanClass(UserD.class);
//        registry.registerBeanDefinition("userD",beanDefinition);
//
//        BeanDefinitionBuilder bdb1 = BeanDefinitionBuilder.genericBeanDefinition();
//        AbstractBeanDefinition beanDefinition1 = bdb1.getBeanDefinition();
//        beanDefinition1.setBeanClass(UserD.class);
//        registry.registerBeanDefinition("userE",beanDefinition1);
    }
}
