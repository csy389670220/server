package com.example.csy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyeurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyeurekaApplication.class, args);
    }

}
