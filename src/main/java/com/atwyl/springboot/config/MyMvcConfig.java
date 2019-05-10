package com.atwyl.springboot.config;


import com.atwyl.springboot.component.LoginHandlerIntercepter;
import com.atwyl.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.config.annotation.*;

/**
 * 自定义配置器
 */

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能(WebMvcConfigurerAdapter过时)
//使用WebMvcConfigurationSupport可以来扩展SpringMVC的功能但是WebMvcConfigurationSupport会全部托管springmvc,因此不可用

/**
 * 由于WebMvcConfigurerAdapter是直接实现WebMvcConfigurer的，因此我们也可以直接实现WebMvcConfigurer达到目的
 * 由于里面的方法默认都是default，因此可以选择实现
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    //所有的WebMvcConfigurationSupport组件都会一起起作用
    @Bean    //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurationSupport(){
        WebMvcConfigurer support = new WebMvcConfigurer(){



            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //SpringBoot已经做好了静态资源映射(拦截哪些URL)
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/index","/user/login","/index.html");

            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

        };

        return support;
    }
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }
}
