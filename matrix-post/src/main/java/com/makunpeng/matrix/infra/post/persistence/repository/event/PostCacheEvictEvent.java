package com.makunpeng.matrix.infra.post.persistence.repository.event;

import org.springframework.context.ApplicationEvent;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 缓存更新事件 - 删除
 * @author Aaron Ma
 * @since 1.0
 */
public class PostCacheEvictEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PostCacheEvictEvent(Object source) {
        super(source);
    }

    public PostCacheEvictEvent(Object source, Long pid) {
        super(source);
        this.pids = List.of(pid);
    }

    public PostCacheEvictEvent(Object source, Collection<Long> pids) {
        super(source);
        this.pids = pids;
    }

    public Collection<Long> getPids() {
        return pids;
    }

    private Collection<Long> pids;
}
