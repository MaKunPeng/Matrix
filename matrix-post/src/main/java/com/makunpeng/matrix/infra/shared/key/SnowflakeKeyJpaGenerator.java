package com.makunpeng.matrix.infra.shared.key;

import com.makunpeng.matrix.infra.shared.util.SpringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * 用于 Spring Jpa 自定义主键生成
 *
 * @author Aaron Ma
 */
public class SnowflakeKeyJpaGenerator extends IdentityGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        SnowflakeKeyGenerator keyGenerator = SpringUtils.getBean(SnowflakeKeyGenerator.class);
        Long key = keyGenerator.generateKey();
        if (key != null) {
            return key;
        }

        return super.generate(s, obj);
    }
}
