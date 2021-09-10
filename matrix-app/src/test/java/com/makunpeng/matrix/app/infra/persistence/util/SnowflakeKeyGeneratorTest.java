package com.makunpeng.matrix.app.infra.persistence.util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnowflakeKeyGeneratorTest {

    @Test
    void testGenerateKey() {
        for (int i = 20; i > 0; i--) {
            Long aLong = SnowflakeKeyGenerator.generateKey();
            System.out.println(aLong);
        }
    }
}