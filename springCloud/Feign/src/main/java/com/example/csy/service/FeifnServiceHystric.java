package com.example.csy.service;

import org.springframework.stereotype.Component;

@Component
public class FeifnServiceHystric  implements  FeifnService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public String verification(String cardName, String cardID, String startDate, String endDate) {
        return null;
    }

}
