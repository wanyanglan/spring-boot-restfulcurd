# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
# 问题1：
* 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能(WebMvcConfigurerAdapter过时)
* 使用WebMvcConfigurationSupport可以来扩展SpringMVC的功能但是WebMvcConfigurationSupport会全部接管springmvc,会把一些静态资源屏蔽，而且使得application.properties里面的配置失效，因此不可用
* 由于WebMvcConfigurerAdapter是直接实现WebMvcConfigurer的，因此我们也可以直接实现WebMvcConfigurer达到目的
* 由于里面的方法默认都是default，因此可以选择实现
 
# 注解的意思
* @Service用于标注业务层组件
  
  @Controller用于标注控制层组件（如struts中的action）
  
  @Repository用于标注数据访问组件，即DAO组件
  
  @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。  