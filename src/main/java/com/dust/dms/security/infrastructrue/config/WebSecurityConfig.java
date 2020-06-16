package com.dust.dms.security.infrastructrue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Author makunpeng
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        //不需要保护的资源路径允许访问
        for (String url : getIgnoreUrlsConfig().getUrls()) {
            registry.antMatchers(url).permitAll();
        }
    }

    /**
     * 获取并注入要忽略的url配置
     * @return
     */
    @Bean
    private IgnoreUrlsConfig getIgnoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }
}
