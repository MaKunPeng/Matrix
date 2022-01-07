package com.makunpeng.matrix.common.code;

/**
 * 业务唯一编码生成器 <br>
 * 目前为简单实现，后续将分离为服务单独部署
 *
 * @author Aaron Ma
 */
public class BusinessUniqueCodeGenerator {
    public static String getStringCode() {
        return null;
    }

    /**
     * 利用 Redis incr 实现
     * @param codeObj 编码对象
     * @return 唯一业务编码
     */
    public static Long getLongCode(Object codeObj) {

        return null;
    }
}
