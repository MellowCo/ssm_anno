package com.li.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Program: ssm_anno
 * @ClassName: SpringConfig
 * @Description: spring配置文件
 * @Author: li
 * @Create: 2019-08-06 14:17
 */

@Configuration
@ComponentScan("com.li.services")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,TransactionManagement.class})
@MapperScan("com.li.mapper") //指定basePackages，扫描mybatis Mapper接口类
@EnableTransactionManagement //开启 spring 对注解事务的支持
public class SpringConfig {

}
