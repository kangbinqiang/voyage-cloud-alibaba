package com.voyage.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Slf4j
@Api(tags = "Hello Controller")
public class HelloController {

    @GetMapping
    @ApiOperation(value = "测试")
    public String sayHello() {
        return "hello world";
    }
}
