package com.makunpeng.matrix.infra.shared.aop;

import com.makunpeng.matrix.infra.shared.util.HttpUtils;
import com.makunpeng.matrix.interfaces.post.api.ApiResultStatus;
import com.makunpeng.matrix.interfaces.post.api.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * Controller全局异常处理类
 *
 * @author Aaron Ma
 * @version 1.0
 * @since 1.0
 **/
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult<?> exceptionHandler(Exception e) {
        logError(e);
        return ResponseResult.of(ApiResultStatus.FAILED);
    }

    /**
     * 记录异常日志
     * @param e 异常
     */
    private static void logError(Exception e) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Objects.requireNonNull(requestAttributes);
        HttpServletRequest request = requestAttributes.getRequest();
        String ipAddress = HttpUtils.getIpAddress(request);
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        HttpHeaders headers = HttpUtils.getHttpHeaders(request);
        String body = null;
        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
            body = StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding()));
            // body 显示长度控制
        }
        String separator = System.lineSeparator();

        StringBuilder builder = new StringBuilder();
        builder.append(separator)
                .append("URI: ").append(url).append(separator)
                .append("HTTP_METHOD: ").append(httpMethod).append(separator)
                .append("HEADERS: ").append(headers).append(separator)
                .append("REQUEST_BODY: ").append(body).append(separator)
                .append("CLIENT_IP: ").append(ipAddress).append(separator)
                .append("Exception Stacktrace:");

        logger.error(builder.toString(), e);
    }
}
