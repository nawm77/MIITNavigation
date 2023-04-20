package com.example.miitnavigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class MiitNavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiitNavigationApplication.class, args);
        System.out.println(Arrays.toString(System.getenv("MY_ARGS").split(" ")));
    }

}
