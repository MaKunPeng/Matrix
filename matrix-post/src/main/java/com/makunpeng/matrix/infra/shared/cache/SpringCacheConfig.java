package com.makunpeng.matrix.infra.shared.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring 缓存配置
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@Configuration
@EnableCaching
public class SpringCacheConfig extends CachingConfigurerSupport {

    private static final Logger logger = LoggerFactory.getLogger(SpringCacheConfig.class);

    @Bean
    public Object postRedisCache() {
        return null;
    }

    /**
     * 自定义 Key 生成器
     * @return KeyGenerator
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return super.keyGenerator();
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(defaultRedisCacheConfiguration())
                .withInitialCacheConfigurations(initCacheConfigMap())
                .transactionAware()
                .build();
//        redisCacheManager.afterPropertiesSet();
        logger.info("Spring Cache 整合 Redis 自定义配置成功");
        return redisCacheManager;
    }

    /**
     * 默认 Redis 配置
     * @return 配置
     */
    private RedisCacheConfiguration defaultRedisCacheConfiguration() {
        // 配置序列化器
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 此项必须配置，否则获取缓存时会报 class java.util.LinkedHashMap cannot be cast to xxx 错误
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY);
        jsonRedisSerializer.setObjectMapper(objectMapper);

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(3 * 3600))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer))
                // 变双冒号为单冒号
                .computePrefixWith(name -> name + ":")
                .disableCachingNullValues();
        return redisCacheConfiguration;
    }

    private Map<String, RedisCacheConfiguration> initCacheConfigMap() {
        Map<String, RedisCacheConfiguration> configMap = new HashMap();
        /*
         * key : cache name
         * value: cache config
         */
        configMap.put("post", defaultRedisCacheConfiguration());
        return configMap;
    }
}
