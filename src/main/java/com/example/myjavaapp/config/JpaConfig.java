package com.example.myjavaapp.config;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    @Value("${jdbc.url}")
    private String env;

    @Bean
    public DataSource getDataSource() {
        System.out.println("env " + env);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://" + env + "/my_java_app");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        return dataSourceBuilder.build();
    }

}
