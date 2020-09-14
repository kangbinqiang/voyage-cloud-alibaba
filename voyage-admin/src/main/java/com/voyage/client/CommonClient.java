package com.voyage.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "voyage-common")
public interface CommonClient {

    @GetMapping("hello")
    public String sayHello();
}
