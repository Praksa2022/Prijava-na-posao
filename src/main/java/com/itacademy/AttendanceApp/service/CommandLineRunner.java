package com.itacademy.AttendanceApp.service;

import com.itacademy.AttendanceApp.AttendanceAppApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@SpringBootApplication
public class CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AttendanceAppApplication.class, args);
        TimeEntryService timeEntryService = applicationContext.getBean(TimeEntryService.class);
        timeEntryService.doSth(args);
    }

    @Service
    class TimeEntryService {
        public void doSth(String[] args) {
            System.out.println(Arrays.toString(args));
        }
    }
}
