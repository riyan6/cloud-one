package com.example.cloud;

import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class CloudOtherAppTest {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void incKey() {
        // 各个类型的新增
        // redisTemplate.opsForValue().set("test:20230312:1", "测试，时间：" + DateUtil.now());
        // redisTemplate.opsForHash().put("test:hash:testput", "time", DateUtil.now());
        // redisTemplate.opsForList().leftPush("test:list:testlist", "嘿嘿");
        // redisTemplate.opsForSet().add("test:set:score", IdUtil.getSnowflake().nextId(), IdUtil.getSnowflake().nextId(), IdUtil.getSnowflake().nextId());
        // redisTemplate.opsForZSet().add("test:zset:score", IdUtil.getSnowflake().nextId(), 130);
    }

}