package com.kpi.springcourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringcourseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringcourseApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from Spring Boot");
    }
}
