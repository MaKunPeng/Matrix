package com.dust.ms.user.interfaces.facade;

import com.dust.ms.user.interfaces.dto.UpdatePasswordParam;
import com.dust.ms.user.interfaces.dto.UserLoginParam;
import com.dust.ms.user.interfaces.dto.UserRegisterParam;
import com.dust.ms.user.domain.user.entity.User;
import com.dust.ms.user.domain.user.repository.UserRepository;
import com.dust.ms.common.interfaces.dto.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * @Author MaKunPeng
 * @Description 用户登陆控制器
 * @Date 21:28 2020/5/11
 * @Version 1.0
 **/
@RestController
public class UserAccessController {

    private UserRepository userRepository;

    @Autowired
    public UserAccessController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public CommonResult login(@RequestBody UserLoginParam loginParam) {
        List<User> users = userRepository.findByEmail(loginParam.getEmail());
        if (users == null || users.size() == 0) {
            users = userRepository.findByUsername(loginParam.getUsername());
            if (users == null || users.size() == 0) {
                return CommonResult.validateFailed("用户名(邮箱)或密码错误");
            }
        }
        if (users.get(0).getStatus() == 0) {
            return CommonResult.validateFailed("帐户处于禁用状态，请激活");
        }
        String token = "123456";
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("user", users.get(0));
        return CommonResult.success(tokenMap);
    }

    @PostMapping("/signup")
    public CommonResult register(@RequestBody UserRegisterParam registerParam) {
        List<User> users = userRepository.findByEmail(registerParam.getEmail());
        List<User> usersByUsername = userRepository.findByUsername(registerParam.getUsername());
        if (users != null && users.size() != 0) {
            return CommonResult.validateFailed("邮箱已注册");
        }
        if (usersByUsername != null && usersByUsername.size() != 0) {
            return CommonResult.validateFailed("用户名已存在");
        }
        User user = new User();
        user.setUsername(registerParam.getUsername());
        user.setEmail(registerParam.getEmail());
        user.setPassword(registerParam.getPassword());
        user.setStatus(1);
        User savedUser = userRepository.save(user);

        // 另起线程，发送邮件
//        try{
//            new Thread(new MailSender(registerParam.getEmail(), user.getUsername())).run();
//        } catch (Exception e) {
//            System.out.println("邮件发送失败");
//        }
        return CommonResult.success(user);
    }

    @PostMapping(value = "/forgot")
    public CommonResult forgetPassword(@RequestBody UpdatePasswordParam updatePasswordParam) {
        if (updatePasswordParam.getEmail() != null && updatePasswordParam.getEmail().trim().length() > 0) {
            // 发送邮件，重置密码
        }
        return null;
    }

    @PutMapping("/activate/{username}")
    public CommonResult activate(@PathVariable("username") String username) {
        List<User> usersByUsername = userRepository.findByUsername(username);
        if (usersByUsername == null && usersByUsername.size() == 0) {
            return CommonResult.validateFailed("用户不存在");
        }
        User user = usersByUsername.get(0);
        user.setStatus(1);
        User savedUser = userRepository.save(user);
        return CommonResult.success(user);
    }
}
