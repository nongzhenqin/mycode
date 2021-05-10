package com.nong.redis;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(JSONObject.toJSONString(list));
        Long test = redisTemplate.opsForList().leftPushAll("test1", list);
        System.out.println(test);
    }

    @Test
    public void readList(){
        ListOperations opsForList = redisTemplate.opsForList();
        List<String> test = opsForList.range("test1", 0, -1);
        System.out.println(JSONObject.toJSONString(test));
    }

    @Test
    public void testLock(){
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", true, 30, TimeUnit.SECONDS);
        System.out.println(lock);
    }
}
