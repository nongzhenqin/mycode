package com.nong.spring;

import org.bouncycastle.util.test.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author nongzhenqin
 * @version 1.0
 * @ClassName TestSpringBean
 * @description 测试Spring bean创建等原理
 * @date 2021/3/6 23:42
 */
public class TestSpringBean {

    @org.junit.Test
    public void testBeanCreate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/beanFactoryTest.xml");

        TestBeanService testBeanService = (TestBeanService) applicationContext.getBean("testBeanService");

        System.out.println(testBeanService.getName());
    }
}
