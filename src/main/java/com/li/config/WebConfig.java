package com.li.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.nio.charset.StandardCharsets;

/**
 * @Program: ssm_anno
 * @ClassName: WebConfig
 * @Description: 替代web.xml
 * @Author: li
 * @Create: 2019-08-06 15:18
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //设置加载spring配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringConfig.class};
    }

    //设置加载springmvc配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringMvcConfig.class};
    }

    //设置springmvc 前端控制器的映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //动态注册过滤器
        //使用动态注册过滤器的API
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
        //设置初始化参数
        encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

        super.onStartup(servletContext);
    }



}
