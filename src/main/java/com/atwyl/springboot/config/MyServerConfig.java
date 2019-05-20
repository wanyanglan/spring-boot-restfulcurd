package com.atwyl.springboot.config;

import com.atwyl.springboot.filter.MyFilter;
import com.atwyl.springboot.listener.MyListener;
import com.atwyl.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean(new MyListener());
        return registrationBean;
    }


    //配置嵌入式的Servlet容器(java代码实现设置tomcat的端口)暂时不可用1.x的使用方式
//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
//        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){
//            @Override
//            public void customize(ConfigurableWebServerFactory factory) {
//                //定制嵌入式的Servlet容器相关的规则
//                factory.setPort(8085);
//            }
//        };
//    }
    // SpringBoot2.x定制和修改Servlet容器的相关配置，使用配置类(方法1)
    /*@Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8585);
        return factory;
    }*/

    //向IoC容器中添加servlet容器工厂定制器（方法2）
    /*@Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> myWebServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
            public void customize(TomcatServletWebServerFactory factory) {
                //设置相关配置
                factory.setPort(8082);
            }
        };
    }*/
}
