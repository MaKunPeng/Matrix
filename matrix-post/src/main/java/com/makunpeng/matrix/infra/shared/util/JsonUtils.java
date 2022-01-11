package com.makunpeng.matrix.infra.shared.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * JSON 工具类
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static {
        // 忽略json中在对象不存在对应属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 忽略空bean转json错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    }

    /**
     * Json 解析为对象
     * @param jsonStr json字符串
     * @param classType 对象类型
     * @param <T> 对象类型
     * @return 对象
     */
    public static <T> T parse(String jsonStr, Class<T> classType) {
        if (StringUtils.isEmpty(jsonStr)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonStr, classType);
        } catch (IOException e) {
            logger.warn("An error occurred while transforming Json to Object. json:{}", jsonStr, e);
        }
        return null;
    }

    /**
     * 对象解析为 Json
     * @param obj 对象
     * @return json字符串
     */
    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            logger.warn("An error occurred while transforming Object to Json String.", e);
        }
        return null;
    }

    /**
     * 对象解析为格式化的 Json
     * @param obj 对象
     * @return json字符串
     */
    public static String toJsonWithFormat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            logger.warn("An error occurred while transforming Object to Json String.", e);
        }
        return null;
    }

    /**
     * 日志格式 Json，根据自定义注解处理
     * @param obj param
     * @return json
     */
    public static String toJsonForLog(Object obj) {
        return null;
    }
}
