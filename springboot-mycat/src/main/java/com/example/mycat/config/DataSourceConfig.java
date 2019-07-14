package com.example.mycat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author : zhaojh
 * @date : 2019-07-14
 * @function : 数据源配置类
 */
@Configuration
public class DataSourceConfig {

    /**
     * 主数据源
     * @return
     */
    @Bean(value="master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(){
        return DataSourceBuilder.create().build();

    }

    /**
     * 从数据库
     */
    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.slave.datasource")
    public DataSource dataSourceSlave(){
        return DataSourceBuilder.create().build();
    }

}
