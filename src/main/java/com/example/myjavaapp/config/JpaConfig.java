package com.example.myjavaapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JpaConfig {

    @Value("${test}")
    private String test;

    @PostConstruct
    public void test() {
        System.out.println("---------bdv-init-----------");
        System.out.println(test);
    }

//    @Bean
//    public DataSource getDataSource() {
//        System.out.println("env " + env);
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://" + env + "/my_java_app");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("root");
//        return dataSourceBuilder.build();
//    }



}
