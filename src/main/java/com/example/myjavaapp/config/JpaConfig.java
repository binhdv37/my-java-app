package com.example.myjavaapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Value("${DB.HOST}")
    private String dbHost;

    @Value("${DB.USERNAME}")
    private String dbUsername;

    @Value("${DB.PASSWORD}")
    private String dbPassword;

    @PostConstruct
    public void test() {
        System.out.println("---------bdv-init-----------");
        System.out.println("DB_HOST: " + dbHost);
        System.out.println("DB_USERNAME: " + dbUsername);
        System.out.println("DB_PASSWORD: " + dbPassword);
    }

    @Bean
    public DataSource getDataSource() {
        System.out.println("---- env: " + dbHost);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://" + dbHost + "/my_java_app");
        dataSourceBuilder.username(dbUsername);
        dataSourceBuilder.password(dbPassword);
        return dataSourceBuilder.build();
    }



}
