package com.makunpeng.matrix.infra.post.persistence.repository.listener;

import com.makunpeng.matrix.infra.post.persistence.repository.event.PostCacheEvictEvent;
import com.makunpeng.matrix.infra.post.persistence.repository.event.PostCachePutEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PostCacheListener {
    private static final Logger logger = LoggerFactory.getLogger(PostCacheListener.class);
    private static final String CACHE_PREFIX = "post";

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public PostCacheListener(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @EventListener
    public void put(PostCachePutEvent event) {
        // 暂用不到
    }

    /**
     * 删除指定缓存
     * @param event 事件对象
     */
    @EventListener
    public void evict(PostCacheEvictEvent event) {
        Collection<Long> pids = event.getPids();
        if (CollectionUtils.isEmpty(pids)) {
            return;
        }
        List<String> keys = new ArrayList<>();
        for (Long pid : pids) {
            keys.add("post:detail:" + pid);
        }
        redisTemplate.delete(keys);
    }
}
