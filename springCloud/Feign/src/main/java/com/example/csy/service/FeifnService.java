package com.example.csy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *定义一个feign接口，
 * 通过@ FeignClient（“服务名”）
 *     @RequestMapping(value = "/接口名")，来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口；
 *接口参数需要@RequestParam
 */
@FeignClient(value = "service-psid",fallback = FeifnServiceHystric.class)
public interface FeifnService {

    @RequestMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/verification")
    String verification(@RequestParam(value = "cardName")String  cardName, @RequestParam(value = "cardID")String cardID,
                        @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate);
}
