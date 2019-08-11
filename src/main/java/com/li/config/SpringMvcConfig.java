package com.li.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Program: ssm_anno
 * @ClassName: SpringMvcConfig
 * @Description: sprigmvc配置文件
 * @Author: li
 * @Create: 2019-08-06 14:57
 */
@Configuration
@ComponentScan("com.li.controller")
@EnableWebMvc //在XML中使用<mvc:annotation-driven>
public class SpringMvcConfig implements WebMvcConfigurer {

    //配置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //配置文件上传解析器
    //bean的名字必须为multipartResolver
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //设置上传最大尺寸5MB
        resolver.setMaxUploadSize(5242880);
        //设置默认编码
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    //配置静态资源 js css image
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    }

}
