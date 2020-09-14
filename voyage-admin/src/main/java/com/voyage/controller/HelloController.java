package com.voyage.controller;


import com.voyage.client.CommonClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Slf4j
@Api(tags = "Hello Controller")
@RefreshScope
public class HelloController {

    @Value("${config.appName}")
    private String appName;

    private final CommonClient commonClient;

    @Autowired
    public HelloController(CommonClient commonClient) {
        this.commonClient = commonClient;
    }

    @GetMapping
    @ApiOperation(value = "测试")
    public String sayHello() {
        return commonClient.sayHello() + appName;
    }
}
