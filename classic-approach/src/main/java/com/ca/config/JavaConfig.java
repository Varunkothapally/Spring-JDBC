package com.ca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import

@Configuration
@ComponentScan(basePackages = {"com.ca.dao","com.ca.beans"})
@PropertySource("classpath:db.properties")
public class JavaConfig {
    @Bean
    public DataSource dataSource(@Value("${db.driverClassname}") String driverClassname,
                                    @Value("${db.url}") String url,
                                    @Value("${db.username}") String username,
                                    @Value("${db.password}") String password){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, username, password);
        driverManagerDataSource.setDriverClassName(driverClassname);
        return driverManagerDataSource;
    }
    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);

    }
}
