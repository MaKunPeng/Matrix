package com.makunpeng.matrix.app.infra.persistence.util;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

/**
 * 雪花ID生成算法
 * 通过 ShardingSphere 实现 <p>
 * 线程安全
 *
 * @author MaKunPeng
 */
public class SnowflakeKeyGenerator {
    private static final SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
    static {
        snowflakeShardingKeyGenerator.getProperties().put("worker.id", 1);
        snowflakeShardingKeyGenerator.getProperties().put("max.tolerate.time.difference.milliseconds", 1000);
    }

    private  SnowflakeKeyGenerator() {

    }

    public static Long generateKey() {
        Long key = (Long) snowflakeShardingKeyGenerator.generateKey();
        return key;
    }
}
