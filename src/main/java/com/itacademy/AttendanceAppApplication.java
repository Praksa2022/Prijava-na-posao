package com.itacademy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;


@SpringBootApplication
public class AttendanceAppApplication {




    public static void main(String[] args) {
        SpringApplication.run(AttendanceAppApplication.class, args);

        SpringApplication app = new SpringApplication(AttendanceAppApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        app.run(args);
    }

}





