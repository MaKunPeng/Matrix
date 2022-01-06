package com.makunpeng.matrix.post.infra.exception;

import com.makunpeng.matrix.post.common.api.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult<?> exceptionHandler(Exception e) {
        logger.error("业务发生异常", e);
        return ResponseResult.err(e.getMessage()).of(null);
    }
}
