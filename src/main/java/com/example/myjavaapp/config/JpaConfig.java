package com.example.myjavaapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Value("${jdbc.host}")
    private String jdbcHost;

    @PostConstruct
    public void test() {
        System.out.println("---------bdv-init-----------");
        System.out.println(jdbcHost);
    }

    @Bean
    public DataSource getDataSource() {
        System.out.println("---- env: " + jdbcHost);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://" + jdbcHost + "/my_java_app");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("Root@123");
        return dataSourceBuilder.build();
    }



}
