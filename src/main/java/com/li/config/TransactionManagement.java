package com.li.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Program: ssm_anno
 * @ClassName: TransactionManagement
 * @Description: spring声明式事务管理
 * @Author: li
 * @Create: 2019-08-06 14:39
 */

public class TransactionManagement {

    //配置事务管理
    @Bean("transactionManager")
    DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
