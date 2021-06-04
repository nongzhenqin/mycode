package com.nong.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class TestController {

    @Value("${name}")
    private String name;

    @GetMapping("/test1")
    public Map<String, Object> test1(){
        Map<String, Object> resutl = new HashMap<>();
        resutl.put("name", name);

        return resutl;
    }
}
