package com.dust.dms.user.application;

import com.dust.dms.common.interfaces.dto.api.CommonResult;
import com.dust.dms.user.application.service.UserAccessService;
import com.dust.dms.user.domain.user.entity.User;
import com.dust.dms.user.domain.user.repository.UserRepository;
import com.dust.dms.user.interfaces.dto.UserLoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserAccessServiceImpl
 * @Description 用户访问服务实现类
 * @Author MaKunPeng
 * @Date 2020/6/14 20:05
 * @Version 1.0
 **/
@Service
public class UserAccessServiceImpl implements UserAccessService {
    private UserRepository userRepository;

    @Autowired
    public UserAccessServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 登陆
     * @param loginParam
     * @return
     */
    @Override
    public CommonResult login(UserLoginParam loginParam) {

        return null;
    }

    @Override
    public User regist() {
        return null;
    }

    @Override
    public int updatePassword() {
        return 0;
    }
}
