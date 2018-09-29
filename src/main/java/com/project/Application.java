package com.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * spring boot
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer
 {

     @Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
         return builder.sources(Application.class);
     }


    public static void main( String[] args ){
    	SpringApplication.run(Application.class, args);
    }
}
