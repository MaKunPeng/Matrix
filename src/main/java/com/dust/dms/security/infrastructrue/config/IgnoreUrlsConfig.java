package com.dust.dms.security.infrastructrue.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "dms.secure.ignore")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();
}
