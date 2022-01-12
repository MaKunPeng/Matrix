package com.makunpeng.matrix.interfaces.post.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void redisDelete() {
        redisTemplate.delete("post:detail:17364200");
    }

    @Test
    void redisPut() {
        redisTemplate.boundValueOps("redis:test:123").set("工革草头右框七");
    }
}
