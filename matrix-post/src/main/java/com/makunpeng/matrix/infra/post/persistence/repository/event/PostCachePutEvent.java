package com.makunpeng.matrix.infra.post.persistence.repository.event;

import org.springframework.context.ApplicationEvent;

/**
 * 缓存更新事件 - 新增/更新
 */
public class PostCachePutEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PostCachePutEvent(Object source) {
        super(source);
    }

    private String key;
    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
