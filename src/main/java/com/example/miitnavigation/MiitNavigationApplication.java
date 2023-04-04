package com.example.miitnavigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiitNavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiitNavigationApplication.class, args);
    }

}
