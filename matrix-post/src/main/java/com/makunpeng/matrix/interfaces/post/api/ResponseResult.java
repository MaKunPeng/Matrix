package com.makunpeng.matrix.interfaces.post.api;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * 通用 Http 返回结果对象
 * @author Aaron Ma
 * @since 1.0
 */
@Data
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private String sub_code;
    private String sub_msg;
    private T data;

    private ResponseResult(String code, String msg, String sub_code, String sub_msg, T data) {
        this.code = code;
        this.msg = msg;
        this.sub_code = sub_code;
        this.sub_msg = sub_msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> of(ApiResultStatus status) {
        return of(status, null);
    }

    public static <T> ResponseResult<T> of(ApiResultStatus status, T data) {
        return new DefaultResponseBuilder(status).data(data);
    }

    /**
     * 响应构建接口
     */
    public interface ResponseBuilder {
        <T> ResponseResult<T> data(@Nullable T data);
    }

    /**
     * 默认响应Builder
     */
    private static class DefaultResponseBuilder implements ResponseBuilder {
        private ApiResultStatus status;

        DefaultResponseBuilder(ApiResultStatus status) {
            this.status = status;
        }

        public <T> ResponseResult<T> data(@Nullable T data) {
            return new ResponseResult<>(status.getCode(), status.getMsg(), status.getSub_code(),
                    status.getSub_msg(), data);
        }
    }
}
