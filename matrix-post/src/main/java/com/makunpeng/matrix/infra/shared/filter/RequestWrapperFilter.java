package com.makunpeng.matrix.infra.shared.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求包装过滤器，方便后续获取请求体
 *
 * ServerletRequest的inputStream只能被读取一次，发生异常的时候再想去读取body只能悲催的得到一个已经Closed的Stream。
 *
 * @author Aaron Ma
 * @since 1.0
 */
@Component
public class RequestWrapperFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(new ContentCachingRequestWrapper(request), response);
    }
}
