package com.jizheping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HobbyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HobbyServiceApplication.class, args);
    }

}
