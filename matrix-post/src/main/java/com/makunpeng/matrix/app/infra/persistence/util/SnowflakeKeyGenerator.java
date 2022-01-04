package com.makunpeng.matrix.app.infra.persistence.util;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 雪花ID生成算法
 * 通过 ShardingSphere 实现 <p>
 * 线程安全
 *
 * @author MaKunPeng
 */
@Component
public class SnowflakeKeyGenerator implements InitializingBean {
    @Value("${spring.shardingsphere.sharding.default-key-generator.props.worker.id}")
    private String workId;
    @Value("${spring.shardingsphere.sharding.default-key-generator.props.max.tolerate.time.difference.milliseconds}")
    private String tolerateMilliseconds;

    private SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator;

    public SnowflakeKeyGenerator() {

    }

    public Long generateKey() {
        return (Long) snowflakeShardingKeyGenerator.generateKey();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
        snowflakeShardingKeyGenerator.getProperties().put("worker.id", Integer.valueOf(workId));
        snowflakeShardingKeyGenerator.getProperties().put("max.tolerate.time.difference.milliseconds",
                Integer.valueOf(tolerateMilliseconds));
    }
}
