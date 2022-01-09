package com.makunpeng.matrix.infra.shared.dt;

import org.springframework.stereotype.Component;

/**
 * @author Aaron Ma
 * @version 1.0
 * @since
 **/
@Component
public class TimeService {
    public long getCurrentMillis() {
        return System.currentTimeMillis();
    }
}
