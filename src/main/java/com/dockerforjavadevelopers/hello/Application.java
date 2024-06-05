package com.dockerforjavadevelopers.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @EnableAutoConfiguration
@ComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }

}
