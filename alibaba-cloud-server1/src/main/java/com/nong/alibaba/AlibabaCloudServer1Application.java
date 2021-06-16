package com.nong.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCloudServer1Application {
    public static void main(String[] args){
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AlibabaCloudServer1Application.class, args);
        String userName = applicationContext.getEnvironment().getProperty("name");
        System.err.println("user name :"+userName);
    }
}
