package com.nong.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCloudServer1Application {
    public static void main(String[] args){
        SpringApplication.run(AlibabaCloudServer1Application.class, args);
    }
}
