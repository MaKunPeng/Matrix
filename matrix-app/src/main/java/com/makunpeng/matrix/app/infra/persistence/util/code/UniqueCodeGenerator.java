package com.makunpeng.matrix.app.infra.persistence.util.code;

import java.util.UUID;

/**
 * 唯一编码生成器
 *
 * @author MaKunPeng
 */
public class UniqueCodeGenerator {
    /**
     * 获取UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
