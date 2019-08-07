package com.example.csy.service;

import org.springframework.stereotype.Component;

@Component
public class FeifnServiceHystric  implements  FeifnService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
