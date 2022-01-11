package com.makunpeng.matrix.infra.shared.aop;

import com.makunpeng.matrix.infra.shared.util.HttpUtils;
import com.makunpeng.matrix.infra.shared.util.JsonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 日志切面 <br>
 * 切面顺序为 Ordered.LOWEST_PRECEDENCE - 1，目的是为保证该切面执行顺序在 @Cacheable 注解之前，
 * 因为 @Cacheable 的默认 order 属性也是 Ordered.LOWEST_PRECEDENCE
 *
 * @author Aaron Ma
 * @since 1.0
 */
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    private static final int MAX_PARAM_LENGTH = 2000;

    @Pointcut("execution(public * com.makunpeng.matrix.interfaces..*Controller.*(..))")
    private void pointCut() {

    };

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsed = System.currentTimeMillis() - start;
        // 记录信息
        try {
            logInfo(pjp, result, elapsed);
        } catch (Exception e) {
            logger.debug("Logging Error: ",e);
        }
        return result;
    }

    private static void logInfo(ProceedingJoinPoint pjp, Object result, long elapsed) {
        // 获取方法签名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String classMethodName = method.getDeclaringClass().getName() + "." + method.getName();
        // 获取方法参数
        String paramJson = JsonUtils.toJson(pjp.getArgs());
        // 获取返回值
        String resultJson = JsonUtils.toJson(result);
        // 过长截断处理，应自定义注解，在序列化Json时忽略注解字段
        if (!StringUtils.isEmpty(paramJson) && paramJson.length() > MAX_PARAM_LENGTH) {
            paramJson = paramJson.substring(0, MAX_PARAM_LENGTH) + ".......";
        }
        if (!StringUtils.isEmpty(resultJson) && resultJson.length() > MAX_PARAM_LENGTH) {
            resultJson = resultJson.substring(0, MAX_PARAM_LENGTH) + ".......";
        }

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Objects.requireNonNull(requestAttributes);
        HttpServletRequest request = requestAttributes.getRequest();
        String ipAddress = HttpUtils.getIpAddress(request);
        String url = request.getRequestURL().toString();
        String httpMethod = request.getMethod();
        HttpHeaders headers = HttpUtils.getHttpHeaders(request);

        String separator = System.lineSeparator();

        StringBuilder builder = new StringBuilder();
        builder.append(separator)
                .append("URI: ").append(url).append(separator)
                .append("HTTP_METHOD: ").append(httpMethod).append(separator)
                .append("HEADERS: ").append(headers).append(separator)
                .append("CLIENT_IP: ").append(ipAddress).append(separator)
                .append("HANDLER_METHOD: ").append(classMethodName).append(separator)
                .append("METHOD_PARAM: ").append(paramJson)
                .append(separator).append("METHOD_RETURN: ").append(resultJson)
                .append("ELAPSED_TIME: ").append(elapsed).append("ms");

        logger.info(builder.toString());
    }
}
