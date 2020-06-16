package com.dust.dms.user.application.service;

import com.dust.dms.common.interfaces.dto.api.CommonResult;
import com.dust.dms.user.domain.user.entity.User;
import com.dust.dms.user.interfaces.dto.UserLoginParam;
import org.springframework.stereotype.Service;

public interface UserAccessService {
    CommonResult login(UserLoginParam loginParam);

    User regist();

    int updatePassword();
}
