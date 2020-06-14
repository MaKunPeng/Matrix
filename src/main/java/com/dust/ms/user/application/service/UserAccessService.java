package com.dust.ms.user.application.service;

import com.dust.ms.user.domain.user.entity.User;

public interface UserAccessService {
    String login();

    User regist();

    int updatePassword();
}
