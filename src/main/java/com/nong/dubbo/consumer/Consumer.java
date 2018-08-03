package com.nong.dubbo.consumer;

import com.nong.dubbo.server.facade.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Consumer
 * @Description: 消费端
 * @author NongZhenQin
 * @date 2018-08-03 22:32:07
 */
public class Consumer {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/consumer.xml");
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.hello();
        System.out.println(hello);
    }
}
