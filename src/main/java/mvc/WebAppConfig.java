package mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//WebMvcConfigurationSupport是提供MVC Java配置背后配置的主要类
@Configuration
@ComponentScan("mvc")//扫描包
public class WebAppConfig extends WebMvcConfigurationSupport {

}
