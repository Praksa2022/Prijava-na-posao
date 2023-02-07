package com.itacademy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.util.Collections;


@SpringBootApplication
@ComponentScan("com.itacademy")
public class AttendanceAppApplication implements CommandLineRunner {

    @Value("${server.port}")
    private String port;

     @Autowired
     private Environment env;


     public static void main(String[] args) {

         SpringApplication app = new SpringApplication(AttendanceAppApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "port"));
        app.run(args);


     }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Port from @Value: " + port);
    }
}






