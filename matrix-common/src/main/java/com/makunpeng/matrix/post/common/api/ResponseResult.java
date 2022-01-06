package com.makunpeng.matrix.post.common.api;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * 通用响应传输对象
 * @param <T>
 * @author Aaron Ma
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private String responseCode;
    private String message;

    private ResponseResult(T data, String responseCode, String message) {
        this.data = data;
        this.responseCode = responseCode;
        this.message = message;
    }

    public static ResponseBuilder ok() {
        return new DefaultResponseBuilder("2000", null);
    }

    public static ResponseBuilder err() {
        return err(null);
    }

    public static ResponseBuilder err(String message) {
        return new DefaultResponseBuilder("4000", message);
    }

    /**
     * 响应构建接口
     */
    public interface ResponseBuilder {
        <T> ResponseResult<T> of(@Nullable T data);
    }

    /**
     * 默认响应Builder
     */
    private static class DefaultResponseBuilder implements ResponseBuilder {
        private String responseCode;
        private String message;

        DefaultResponseBuilder(String responseCode, String message) {
            this.responseCode = responseCode;
            this.message = message;
        }

        public <T> ResponseResult<T> of(@Nullable T data) {
            return new ResponseResult<>(data, responseCode, message);
        }
    }
}
