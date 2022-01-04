package com.makunpeng.matrix.app.infra.persistence.util;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SnowflakeKeyGeneratorTest {
    @Autowired
    private SnowflakeKeyGenerator snowflakeKeyGenerator;

    @Test
    void testGenerateKey() {
        for (int i = 20; i > 0; i--) {
            Long aLong = snowflakeKeyGenerator.generateKey();
            System.out.println(aLong);
        }
    }
}