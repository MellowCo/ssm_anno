package com.li.config;

import com.li.interceptor.MyInterceptor1;
import com.li.interceptor.MyInterceptor2;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

    //校验的资源文件
    @Bean("messageSource")
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        //资源文件名
        // source.setBasenames("ValidationMessages");
        //设置编码格式
        source.setDefaultEncoding("UTF-8");
        //对资源文件的缓存时间
        source.setCacheSeconds(120);
        return source;
    }

    //校验器
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(@Qualifier("messageSource") MessageSource msgSorce){
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        //配置hibernate校验器
        factoryBean.setProviderClass(HibernateValidator.class);
        //指定校验的资源文件
        factoryBean.setValidationMessageSource(msgSorce);
        return factoryBean;
    }



    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**").excludePathPatterns("/user/testInterceptor1");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**").excludePathPatterns("/user/testInterceptor2");

    }
}
