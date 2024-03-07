package com.example.cloud.search;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SearchCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(SearchCloudApp.class, args);
    }
}
