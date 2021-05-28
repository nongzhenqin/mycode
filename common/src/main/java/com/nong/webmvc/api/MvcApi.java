package com.nong.webmvc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MvcApi {

    @GetMapping("/hello")
    public String hello(){
        return "Hello world!";
    }
}
