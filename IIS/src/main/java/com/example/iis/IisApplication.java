package com.example.iis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.example.iis.mapper")
public class IisApplication {

    public static void main(String[] args) {
        SpringApplication.run(IisApplication.class, args);
    }

}
